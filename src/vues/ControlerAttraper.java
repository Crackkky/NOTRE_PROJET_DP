package vues;

import java.awt.event.MouseEvent;

public class ControlerAttraper extends ControlerEtat{

    public ControlerAttraper(CadreAngryBalls cadreAngryBalls, ControlerEtat suivant) {
        super(cadreAngryBalls, suivant);
    }

    @Override
    public void traiter(MouseEvent arg0) {
        if(arg0.getButton() == MouseEvent.BUTTON1) {
            //Voir si on a clique sur une balle, si oui, l'attraper
            cadreAngryBalls.controlerEtatcourant = suivant;
        }
    }
}
