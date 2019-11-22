package modele;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

import java.util.Vector;

/**
 * Operations utiles sur les billes
 * <p>
 * ICI : IL N'Y A RIEN A CHANGER
 */

public class OutilsBille {
    /**
     * @param billes     est la liste de TOUTES les billes en mouvement
     * @param cetteBille est l'une d'entre elles.
     * @return la liste des autres billes que cetteBille, c'est-e-dire la liste de toutes les billes sauf cetteBille
     */
    public static Vector<Bille> autresBilles(Bille cetteBille, Vector<Bille> billes) {
        Vector<Bille> autresBilles = new Vector<Bille>();

        Bille billeCourante;

        int i;

        for (i = 0; i < billes.size(); ++i) {
            billeCourante = billes.get(i);
            if (billeCourante.getClef() != cetteBille.getClef())
                autresBilles.add(billeCourante);
        }

        return autresBilles;
    }


    /**
     * @param cetteBille : une bille particuliere
     * @param billes     : une liste de billes, cette liste peut contenir cettebille
     *                   <p>
     *                   gestion de l'eventuelle  collision de cette bille avec les autres billes
     *                   <p>
     *                   billes est la liste de toutes les billes en mouvement
     *                   <p>
     *                   Le comportement par defaut est le choc parfaitement elastique (c-e-d rebond sans amortissement)
     * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliquees dans le choc sont modifiees
     * si renvoie false, il n'y a pas de collision et les billes sont laissees intactes
     */
    public static boolean gestionCollisionBilleBille(Bille cetteBille, Vector<Bille> billes) {
//--- on recupere d'abord dans autresBilles toutes les billes sauf cetteBille ----

        Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, billes);

//--- on cherche e present la 1ere des autres billes avec laquelle cetteBille est en collision ---------------------
//-------------- on suppose qu'il ne peut y avoir de collision qui implique plus de deux billes e la fois ---------------

        Bille billeCourante;

        int i;

        for (i = 0; i < autresBilles.size(); ++i) {
            billeCourante = autresBilles.get(i);
            if (Collisions.CollisionBilleBille(cetteBille.getPosition(), cetteBille.getRayon(), cetteBille.getVitesse(), cetteBille.masse(),
                    billeCourante.getPosition(), billeCourante.getRayon(), billeCourante.getVitesse(), billeCourante.masse()))
                return true;
        }
        return false;
    }


    /**
     * @param cetteBille : une bille particuliere
     * @param billes     : une liste de billes, cette liste peut contenir cettebille
     *                   <p>
     *                   On suppose que cetteBille subit l'attraction gravitationnelle due aux billes contenues dans "billes" autres que cetteBille.
     *                   <p>
     *                   teche : calcule a, le vecteur acceleration subi par cetteBille resultant de l'attraction par les autres billes de la liste.
     * @return a : le vecteur acceleration resultant
     */
    public static Vecteur gestionAccelerationNewton(Bille cetteBille, Vector<Bille> billes) {

//--- on recupere d'abord dans autresBilles toutes les billes sauf celle-ci ----

        Vector<Bille> autresBilles = OutilsBille.autresBilles(cetteBille, billes);

//-------------- e present on recupere les masses et les positions des autres billes ------------------
        int i;
        Bille billeCourante;

        int d = autresBilles.size();

        double masses[] = new double[d];   // les masses des autres billes
        Vecteur C[] = new Vecteur[d];      // les positions des autres billes

        for (i = 0; i < d; ++i) {
            billeCourante = autresBilles.get(i);
            masses[i] = billeCourante.masse();
            C[i] = billeCourante.getPosition();
        }

//------------------ e present on calcule le champ de gravite exerce par les autres billes sur cette bille ------------------

        return MecaniquePoint.champGraviteGlobal(cetteBille.getPosition(), masses, C);
    }

    /**
     * @param bille La bille
     * @return true si le clique survient sur la bille
     */
    public static boolean clickSurBille(int x, int y, Bille bille) {
        Vecteur v = bille.getPosition();
        return Math.sqrt(Math.pow(x - v.x, 2) + Math.pow(v.y - y, 2)) < bille.getRayon();
    }

    public static Bille clickSurUneBille(int x, int y, Vector<Bille> billes) {
        for (Bille bille : billes) {
            if (clickSurBille(x, y, bille))
                return bille;
        }
        return null;
    }

    public static Bille billeAttrapable(Vector<Bille> billes) {
        for(Bille bille : billes) {
            if (bille.estAttrapable()) {
                System.out.println("Bille attrapable : " + bille);
                return bille;
            }
        }
        return null;
    }
}
