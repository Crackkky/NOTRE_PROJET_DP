package modele;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

import java.awt.*;
import java.util.Vector;

/**
 * Cas normal d'une bille tout a fait generale
 */
public class BilleNormal extends Bille {

    public static double ro = 1;        // masse volumique
    private static int prochaineClef = 0;
    public Vecteur position;   // centre de la bille
    public double rayon;            // rayon > 0
    public Vecteur vitesse;
    public Vecteur acceleration;
    public int clef;                // identifiant unique de cette bille
    public Collision collision;
    private Color couleur;

    public BilleNormal(Vecteur centre, double rayon, Vecteur vitesse, Vecteur acceleration, Color couleur, Collision collision) {
        this.position = centre;
        this.rayon = rayon;
        this.vitesse = vitesse;
        this.acceleration = acceleration;
        this.couleur = couleur;
        this.clef = BilleNormal.prochaineClef++;
        this.collision = collision;
    }

    public BilleNormal(Vecteur position, double rayon, Vecteur vitesse, Color couleur, Collision collision) {
        this(position, rayon, vitesse, new Vecteur(), couleur, collision);
    }

    @Override
    public Vecteur getPosition() {
        return this.position;
    }

    @Override
    public double getRayon() {
        return this.rayon;
    }

    @Override
    public Vecteur getVitesse() {
        return this.vitesse;
    }

    @Override
    public Vecteur getAcceleration() {
        return this.acceleration;
    }

    @Override
    public Color getCouleur() {
        return couleur;
    }

    @Override
    public int getClef() {
        return this.clef;
    }

    @Override
    public Collision getCollision() {
        return this.collision;
    }

    @Override
    public double masse() {
        return ro * Geop.volumeSphere(rayon);
    }

    /**
     * calcul (c-e-d mise e jour) eventuel  du vecteur acceleration.
     * billes est la liste de toutes les billes en mouvement
     * Cette methode peut avoir besoin de "billes" si this subit l'attraction gravitationnelle des autres billes
     * La nature du calcul du vecteur acceleration de la bille  est definie dans les classes derivees
     * A ce niveau le vecteur acceleration est mis e zero (c'est e dire pas d'acceleration)
     */
    public void gestionAcceleration(Vector<Bille> billes) {
        this.getAcceleration().set(Vecteur.VECTEURNUL);
    }
}

