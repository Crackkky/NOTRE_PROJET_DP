package modele;

import mesmaths.cinematique.Collisions;
import mesmaths.geometrie.base.Vecteur;

public class MurRebond extends Collision {

    public void collisionContour(Vecteur position, double rayon, Vecteur vitesse,
                                 double abscisseCoinHautGauche, double ordonneeCoinHautGauche,
                                 double largeur, double hauteur) {

        Collisions.collisionBilleContourAvecRebond(position, rayon, vitesse, abscisseCoinHautGauche, ordonneeCoinHautGauche, largeur, hauteur);
    }
}
