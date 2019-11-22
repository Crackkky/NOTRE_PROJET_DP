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

    public Vecteur getAttraction() {
        return attraction;
    }

    public void setAttraction(Vecteur attraction) {
        this.attraction = attraction;
    }
}
