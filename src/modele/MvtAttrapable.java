package modele;

import mesmaths.geometrie.base.Vecteur;

import java.util.Vector;

public class MvtAttrapable extends DecorateurBille{
    Vecteur attraction;

    public MvtAttrapable(Bille billeDecoree, Vecteur attraction) {
        super(billeDecoree);
        this.attraction = attraction;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        this.billeDecoree.gestionAcceleration(billes);
        this.getAcceleration().ajoute(this.attraction);
    }
}
