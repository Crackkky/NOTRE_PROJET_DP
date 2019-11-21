package modele;

import mesmaths.geometrie.base.Vecteur;

public abstract class Collision {

    /**
     * gestion de l'eventuelle collision de la bille (this) avec le contour rectangulaire de l'ecran defini par (abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur)
     * <p>
     * detecte si il y a collision et le cas echeant met e jour position et vitesse
     * <p>
     * La nature du comportement de la bille en reponse e cette collision est definie dans les classes derivees
     */
    public abstract void collisionContour(Vecteur position, double rayon, Vecteur vitesse,
                                          double abscisseCoinHautGauche, double ordonneeCoinHautGauche,
                                          double largeur, double hauteur);
}
