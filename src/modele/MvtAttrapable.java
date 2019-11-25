package modele;

import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

import java.util.Vector;

public class MvtAttrapable extends DecorateurBille{
    Vecteur attraction;

    public MvtAttrapable(Bille billeDecoree) {
        super(billeDecoree);
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        this.billeDecoree.gestionAcceleration(billes);
        if(attraction != null) {
            this.getAcceleration().ajoute(MecaniquePoint.champGravite(attraction, 1, getPosition()));
        }
    }

    public Vecteur getAttraction() {
        return attraction;
    }

    public void setAttraction(Vecteur attraction) {
        this.attraction = attraction;
    }
}
