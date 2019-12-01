package modele;

import mesmaths.geometrie.base.Vecteur;

import java.util.Vector;

/**
* La classe CollisionDetail permet de retourner les détails d'une collision'
 */
public class CollisionDetail {

    public double intensite;
    public Vecteur positionChoc;

    public CollisionDetail(double intensite, Vecteur positionChoc) {
        this.intensite = intensite;
        this.positionChoc = positionChoc;
    }
}
