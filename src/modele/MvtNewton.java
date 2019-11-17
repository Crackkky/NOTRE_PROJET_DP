package modele;

import java.util.Vector;

public class MvtNewton extends DecorateurBille {

    public MvtNewton(Bille billeDecoree) {
        super(billeDecoree);
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        this.billeDecoree.gestionAcceleration(billes);
        this.getAcceleration().ajoute(OutilsBille.gestionAccelerationNewton(this, billes));
    }
}
