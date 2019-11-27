package modele;

import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Vecteur;

import java.awt.*;
import java.util.Vector;


/**
 * Cas general d'une bille de billard
 * <p>
 * A MODIFIER
 */
public abstract class Bille {

    public abstract Vecteur getPosition();

    public abstract Object getMvt(Class<?> c);

    public abstract double getRayon();

    public abstract Vecteur getVitesse();

    public abstract Vecteur getAcceleration();

    public abstract Color getCouleur();

    public abstract int getClef();

    public abstract Collision getCollision();

    public abstract double masse();

    /**
     * mise e jour de getPosition() et vitesse e t+deltaT e partir de getPosition() et vitesse e l'instant t
     * <p>
     * modifie le vecteur getPosition() et le vecteur vitesse
     * <p>
     * laisse le vecteur acceleration intact
     * <p>
     * La bille subit par defaut un mouvement uniformement accelere
     */
    public void deplacer(double deltaT) {
        Cinematique.mouvementUniformementAccelere(this.getPosition(), this.getVitesse(), this.getAcceleration(), deltaT);
    }

    /**
     * calcul (c-e-d mise e jour) eventuel  du vecteur acceleration.
     * billes est la liste de toutes les billes en mouvement
     * Cette methode peut avoir besoin de "billes" si this subit l'attraction gravitationnelle des autres billes
     * La nature du calcul du vecteur acceleration de la bille  est definie dans les classes derivees
     * A ce niveau le vecteur acceleration est mis e zero (c'est e dire pas d'acceleration)
     */
    public abstract void gestionAcceleration(Vector<Bille> billes);

    /**
     * gestion de l'eventuelle  collision de cette bille avec les autres billes
     * <p>
     * billes est la liste de toutes les billes en mouvement
     * <p>
     * Le comportement par defaut est le choc parfaitement elastique (c-e-d rebond sans amortissement)
     *
     * @return true si il y a collision et dans ce cas les getPosition()s et vecteurs vitesses des 2 billes impliquees dans le choc sont modifiees
     * si renvoie false, il n'y a pas de collision et les billes sont laissees intactes
     */
    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        return OutilsBille.gestionCollisionBilleBille(this, billes);
    }


    public void dessine(Graphics g) {
        int width, height;
        int xMin, yMin;

        xMin = (int) Math.round(getPosition().x - getRayon());
        yMin = (int) Math.round(getPosition().y - getRayon());

        width = height = 2 * (int) Math.round(getRayon());

        g.setColor(getCouleur());
        g.fillOval(xMin, yMin, width, height);
        g.setColor(Color.CYAN);
        g.drawOval(xMin, yMin, width, height);
    }

//
//    public String toString() {
//        return "[pos : " + getPosition() + ", ray : " + getRayon() + ", vit : " + getVitesse() + ", acc : " + getAcceleration() +
//                ", col : " + getCouleur() + ", key : " + getClef() + ", " + "]\n";
//    }


    public String toString() {
        return "[Couleur : " + getCouleur() + ", Masse : " + masse() + ", Rayon : " + getRayon() + "]\n";
    }

//----------------- classe Bille -------------------------------------
}

