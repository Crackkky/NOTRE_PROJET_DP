package modele;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

public class MurPasseMuraille extends Collision {

    public void collisionContour(Vecteur position, double rayon, Vecteur vitesse,
                                 double abscisseCoinHautGauche, double ordonneeCoinHautGauche,
                                 double largeur, double hauteur) {

        Collisions.collisionBilleContourPasseMuraille(position, abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }
}
