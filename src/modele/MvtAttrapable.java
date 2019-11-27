package modele;

import mesmaths.geometrie.base.Vecteur;

import java.util.Vector;

public class MvtAttrapable extends DecorateurBille{
    public static double calibrage = 60;
    public Vecteur directionCurseur;

    public MvtAttrapable(Bille billeDecoree) {
        super(billeDecoree);
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        this.billeDecoree.gestionAcceleration(billes);
        if (directionCurseur != null) {
            this.getAcceleration().ajoute(directionCurseur.produit(calibrage).produit(1 / masse()));
        }
    }
}
