package modele;

import java.util.Vector;

public class MvtSonore extends DecorateurBille {
    Sound soundPlayer;
    String soundPath;

    public MvtSonore(Bille billeDecoree, Sound soundPlayer, String soundPath) {
        super(billeDecoree);
        this.soundPath = soundPath;
        this.soundPlayer = soundPlayer;
    }

    public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
        boolean collision;
        if(collision = super.gestionCollisionBilleBille(billes)) {
            soundPlayer.playSound(soundPath, 0, 1);
        }
        return collision;
    }
}
