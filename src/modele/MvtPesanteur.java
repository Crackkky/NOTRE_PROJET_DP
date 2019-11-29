package modele;

import mesmaths.geometrie.base.Vecteur;

import java.util.Vector;

public class MvtPesanteur extends DecorateurBille {
    Vecteur pesanteur;

    public MvtPesanteur(Bille billeDecoree, Vecteur pesanteur) {
        super(billeDecoree);
        this.pesanteur = pesanteur;
    }

    @Override
    public void gestionAcceleration(Vector<Bille> billes) {
        super.gestionAcceleration(billes);
        this.getAcceleration().ajoute(this.pesanteur);
    }
}
