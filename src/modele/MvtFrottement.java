package modele;

import mesmaths.mecanique.MecaniquePoint;

import java.util.Vector;

public class MvtFrottement extends DecorateurBille {

    public MvtFrottement(Bille billeDecoree) {
        super(billeDecoree);
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        this.billeDecoree.gestionAcceleration(billes);
        this.getAcceleration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));      // contribution de l'acceleration due au frottement dans l'air
    }
}
