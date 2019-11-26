package modele;

import mesmaths.geometrie.base.Vecteur;

import java.util.Vector;

public class MvtAttrapable extends DecorateurBille{
    public Vecteur precCoordCurseur;
    public Vecteur coordCurseur;

    public double calibrage = 0.000999;

    public MvtAttrapable(Bille billeDecoree) {
        super(billeDecoree);
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        this.billeDecoree.gestionAcceleration(billes);
        if (coordCurseur != null) {
            this.getAcceleration().ajoute(new Vecteur(coordCurseur.x - precCoordCurseur.x, coordCurseur.y - precCoordCurseur.y).produit(calibrage));
        }
    }
    public Vecteur getCoordCurseur() {
        return coordCurseur;
    }

    public Vecteur getPrecCoordCurseur() {
        return precCoordCurseur;
    }
}
