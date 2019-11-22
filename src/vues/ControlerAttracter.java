package vues;

import modele.Bille;

import java.awt.event.MouseEvent;
import java.util.Vector;

public class ControlerAttracter extends ControlerEtat{

    public ControlerAttracter(CadreAngryBalls cadreAngryBalls, ControlerEtat suivant) {
        super(cadreAngryBalls, suivant);
    }

    @Override
    public void traiter(MouseEvent arg0, Bille bille) {
        bille.attrapee = false;
        cadreAngryBalls.controlerEtatcourant = suivant;
    }

    @Override
    public void traiterDrag(MouseEvent arg0, Bille bille, Vector<Bille> billes) {
        if(arg0.getButton() == MouseEvent.MOUSE_DRAGGED) {
            //Deplacer la bille en fonction du mouvement de la souris
        }
//        else { //TODO "traiter" et "traiterDrag" correspond au "if"
//            if(arg0.getButton() == MouseEvent.MOUSE_RELEASED) {
//                Lancer la boule
//                cadreAngryBalls.controlerEtatcourant = suivant;
//            }
//        }
    }

    @Override
    public String toString() {
        return "ControlerAttracter";
    }
}
