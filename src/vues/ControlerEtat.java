package vues;

import java.awt.event.MouseEvent;

public abstract class ControlerEtat {
    public CadreAngryBalls cadreAngryBalls;
    public ControlerEtat suivant;

    public ControlerEtat(CadreAngryBalls cadreAngryBalls, ControlerEtat suivant) {
        this.cadreAngryBalls = cadreAngryBalls;
        this.suivant = suivant;
    }

    public abstract void traiter(MouseEvent arg0);

}
