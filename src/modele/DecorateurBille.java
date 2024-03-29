package modele;

import mesmaths.geometrie.base.Vecteur;

import java.awt.*;
import java.util.Vector;


public abstract class DecorateurBille extends Bille {
    public Bille billeDecoree;

    protected DecorateurBille(Bille billeDecoree) {
        this.billeDecoree = billeDecoree;
    }

    @Override
    public Vecteur getPosition() {
        return this.billeDecoree.getPosition(); // par defaut, le nom du decorateur de l'objet est le meme que le nom de l'objet decore
        // cette methode est donc recursive. Le cas terminal est le cas du maillon du fin : l'objet ordinaire
    }

    @Override
    public Object getMvt(Class<?> c) {
        return getMvtRecursif(c, this);
    }

    private Object getMvtRecursif(Class<?> c, DecorateurBille decorateurBille) {
        if (decorateurBille.getClass() == c)
            return decorateurBille;
        return decorateurBille.billeDecoree instanceof DecorateurBille ? getMvtRecursif(c, (DecorateurBille) decorateurBille.billeDecoree) : null;
    }

    @Override
    public double getRayon() {
        return this.billeDecoree.getRayon();
    }

    @Override
    public Vecteur getVitesse() {
        return this.billeDecoree.getVitesse();
    }

    @Override
    public Vecteur getAcceleration() {
        return this.billeDecoree.getAcceleration();
    }

    @Override
    public Color getCouleur() {
        return this.billeDecoree.getCouleur();
    }

    @Override
    public int getClef() {
        return this.billeDecoree.getClef();
    }

    @Override
    public Collision getCollision() {
        return this.billeDecoree.getCollision();
    }

    @Override
    public double masse() {
        return this.billeDecoree.masse();
    }

    @Override
    public void deplacer(double deltaT) {
        this.billeDecoree.deplacer(deltaT);
    }

    @Override
    public CollisionBilleDetail gestionCollisionBilleBille(Vector<Bille> billes) {
        return this.billeDecoree.gestionCollisionBilleBille(billes);
    }

    @Override
    public void dessine(Graphics g) {
        this.billeDecoree.dessine(g);
    }

    @Override
    public String toString() {
        return this.billeDecoree.toString();
    }


    /**
     * On ne sait pas encore comment la bille va accélérer.
     */
    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        this.billeDecoree.gestionAcceleration(billes);
    }

}
