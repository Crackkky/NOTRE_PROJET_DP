package modele;

import java.util.Vector;

public class MvtSonore extends DecorateurBille {
    static final double MAX_COEF_SON = 2; // L'intensite qui donnera le volume maximum
    double centreSonoreAffichage;
    Sound soundPlayer;
    String soundPath;

    public MvtSonore(Bille billeDecoree, Sound soundPlayer, String soundPath, double largeurAffichage) {
        super(billeDecoree);
        this.soundPath = soundPath;
        this.soundPlayer = soundPlayer;
        this.centreSonoreAffichage = largeurAffichage / 2;
    }

    public CollisionBilleDetail gestionCollisionBilleBille(Vector<Bille> billes) {
        CollisionBilleDetail collisionBilleDetail;

        if ((collisionBilleDetail = super.gestionCollisionBilleBille(billes)) != null) {
            //Interprétation des caractéristiques du choc
            double balance = (collisionBilleDetail.collisionDetail.positionChoc.x - centreSonoreAffichage) / centreSonoreAffichage,
                    volume = collisionBilleDetail.collisionDetail.intensite / MAX_COEF_SON;
            //On teste si la deuxieme bille a quelque chose à dire
            Bille bille2 = collisionBilleDetail.bille2;
            Object o = bille2.getMvt(getClass());
            if (o != null) {
                MvtSonore mvtSonore = (MvtSonore) o;
                mvtSonore.playSound(balance, volume);
            }
            //Ensuite seulement on parle, qu'est-ce qu'on est poli !
            playSound(balance, volume);
        }
        return collisionBilleDetail;
    }

    public void playSound(double balance, double volume) {
        soundPlayer.playSound(soundPath, balance, volume);
    }
}
