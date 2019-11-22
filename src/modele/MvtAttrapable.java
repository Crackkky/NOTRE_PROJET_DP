package modele;

import mesmaths.geometrie.base.Vecteur;

import java.util.Vector;

public class MvtAttrapable extends DecorateurBille{

    public MvtAttrapable(Bille billeDecoree) {
        super(billeDecoree);
    }

    @Override
    public boolean estAttrapable() {
        return true;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        this.billeDecoree.gestionAcceleration(billes);
        if (!attrapee)
            this.getAcceleration().ajoute(new Vecteur(0, 0));
        else
            this.getAcceleration().ajoute(new Vecteur(10, 10));

    }

    public Vecteur getAttraction() {
        return attraction;
    }

    public void setAttraction(Vecteur attraction) {
        this.attraction = attraction;
    }
}
