package modele;

import mesmaths.geometrie.base.Vecteur;
import mesmaths.mecanique.MecaniquePoint;

import java.util.Vector;

public class MvtAttrapable extends DecorateurBille{
    public Vecteur coordCurseur;

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
        if (coordCurseur != null) {
            this.getAcceleration().ajoute(MecaniquePoint.champGravite(coordCurseur, 1, getPosition())); //TODO Hum c'est plus du pingpong que d'attraper vraiment la bille
//            this.getAcceleration().ajoute(new Vecteur(coordCurseur.x/100, coordCurseur.y/100));
        }
    }

//    champGraviteGlobal(Vecteur P, double masses[], Vecteur C[])

    public Vecteur getCoordCurseur() {
        return coordCurseur;
    }
}
