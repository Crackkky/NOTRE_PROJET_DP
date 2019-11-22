package vues;

import java.awt.event.MouseEvent;

public class ControlerAttracter extends ControlerEtat{

    public ControlerAttracter(CadreAngryBalls cadreAngryBalls, ControlerEtat suivant) {
        super(cadreAngryBalls, suivant);
    }

    @Override
    public void traiter(MouseEvent arg0) {
        if(arg0.getButton() == MouseEvent.MOUSE_DRAGGED) {
            //Deplacer la bille en fonction du mouvement de la souris
        }
        else {
            if(arg0.getButton() == MouseEvent.MOUSE_RELEASED) {
                //Lancer la boule
                cadreAngryBalls.controlerEtatcourant = suivant;
            }
        }
    }
}
