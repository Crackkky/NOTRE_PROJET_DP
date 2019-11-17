package modele;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

public class MurArret extends Collision {

    public void collisionContour(Vecteur position, double rayon, Vecteur vitesse,
                                 double abscisseCoinHautGauche, double ordonneeCoinHautGauche,
                                 double largeur, double hauteur) {

        Collisions.collisionBilleContourAvecArretHorizontal(position, rayon, vitesse, abscisseCoinHautGauche, largeur);
        Collisions.collisionBilleContourAvecArretVertical(position, rayon, vitesse, ordonneeCoinHautGauche, hauteur);
    }
}
