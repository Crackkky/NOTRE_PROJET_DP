import controleurs.ControleurAttrapeur;
import mesmaths.geometrie.base.Vecteur;
import modele.*;
import vues.CadreAngryBalls;

import java.awt.*;
import java.util.Vector;

/**
 * Gestion d'une liste de billes en mouvement ayant toutes un comportement different
 * <p>
 * Ideal pour mettre en place le DP decorator
 */
public class TestAngryBallsDecore {

    /**
     * @param args
     */
    public static void main(String[] args) {
//------------------- creation de la liste (pour l'instant vide) des billes -----------------------

        Vector<Bille> billes = new Vector<Bille>();


//---------------- creation de la vue responsable du dessin des billes -------------------------

        CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
                "Animation de billes ayant des comportements differents. Situation ideale pour mettre en place le DP Decorator",
                billes);

        ControleurAttrapeur controleurAttrapeur = new ControleurAttrapeur(cadre.billard);

        cadre.montrer(); // on rend visible la vue

//------------- remplissage de la liste avec 4 billes -------------------------------


        double xMax, yMax;
        double vMax = 0.1;
        xMax = cadre.largeurBillard();      // abscisse maximal
        yMax = cadre.hauteurBillard();      // ordonnee maximale

        double rayon = 0.05 * Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le meme rayon, mais ce n'est pas obligatoire

        Vecteur p0, p1, p2, p3, p4, p42, v0, v1, v2, v3, v4, v42;    // les positions des centres des billes et les vecteurs vitesse au demarrage.
        // Elles vont etre choisies aleatoirement

//------------------- creation des vecteurs position des billes ---------------------------------

        p0 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
        p1 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
        p2 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
        p3 = Vecteur.creationAleatoire(0, 0, xMax, yMax);
        p4 = Vecteur.creationAleatoire(0, 0, xMax, yMax);


        p42 = Vecteur.creationAleatoire(0, 0, xMax, yMax);

//------------------- creation des vecteurs vitesse des billes ---------------------------------

        v0 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);
        v1 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, 0);
        v2 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);
        v3 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);
        v4 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);

        v42 = Vecteur.creationAleatoire(-vMax, -vMax, vMax, vMax);

//--------------- ici commence la partie e changer ---------------------------------


        //---- On creer les billes + decoration de noel

        billes.add(new BilleNormal(p0, rayon, v0, Color.red, new MurRebond()));

        billes.add(new MvtPesanteur(
                new MvtNewton(
                        new BilleNormal(p1, rayon, v1, Color.yellow, new MurRebond())), new Vecteur(0, 0.001)));

        billes.add(new MvtNewton(
                new MvtFrottement(
                        new BilleNormal(p2, rayon, v2, Color.green, new MurRebond()))));

        billes.add(new BilleNormal(p3, rayon, v3, Color.cyan, new MurPasseMuraille()));

        billes.add(new MvtNewton(
                new BilleNormal(p4, rayon, v4, Color.black, new MurArret())));


        billes.add(new MvtSonore(new MvtNewton(
                new MvtPesanteur(
                        new MvtFrottement(
                                new MvtAttrapable(
                                        new BilleNormal(p42, rayon, v42, Color.pink, new MurArret()))), new Vecteur(0, 0.001))), new SoundPlayer(), "modele/conflict.mp3"));


//---------------------- ici finit la partie e changer -------------------------------------------------------------


//-------------------- creation de l'objet responsable de l'animation (c'est un thread separe) -----------------------

        AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

//----------------------- mise en place des ecouteurs de boutons qui permettent de contreler (un peu...) l'application -----------------

        EcouteurBoutonLancer ecouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
        EcouteurBoutonArreter ecouteurBoutonArreter = new EcouteurBoutonArreter(animationBilles);

//------------------------- activation des ecouteurs des boutons et ea tourne tout seul ------------------------------

        cadre.lancerBilles.addActionListener(ecouteurBoutonLancer);             // maladroit : e changer
        cadre.arreterBilles.addActionListener(ecouteurBoutonArreter);           // maladroit : e changer
    }
}
