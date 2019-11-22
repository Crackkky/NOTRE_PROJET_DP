package vues;

import modele.Bille;

import java.awt.event.MouseEvent;
import java.util.Vector;

public abstract class ControlerEtat {
    public CadreAngryBalls cadreAngryBalls;
    public ControlerEtat suivant;

    public ControlerEtat(CadreAngryBalls cadreAngryBalls, ControlerEtat suivant) {
        this.cadreAngryBalls = cadreAngryBalls;
        this.suivant = suivant;
    }

    public abstract void traiter(MouseEvent arg0, Bille bille);

    public abstract void traiterDrag(MouseEvent arg0, Bille bille, Vector<Bille> billes); //TODO dans l'un on a besoin du billard mais pas dans l'autre !

}
