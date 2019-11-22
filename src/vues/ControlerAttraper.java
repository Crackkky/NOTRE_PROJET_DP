package vues;

import modele.Bille;

import modele.Bille;
import modele.MvtAttrapable;
import modele.OutilsBille;

import java.awt.event.MouseEvent;
import java.util.Vector;

public class ControlerAttraper extends ControlerEtat{

    public ControlerAttraper(CadreAngryBalls cadreAngryBalls, ControlerEtat suivant) {
        super(cadreAngryBalls, suivant);
    }

    @Override
    public void traiter(MouseEvent arg0, Bille bille1) {
//
//        if(arg0.getButton() == MouseEvent.BUTTON1) {
//
//            if (bille.estAttrapable()) {
//                bille.attrapee = true;
//
//            }
//            //TODO else error
//
//            cadreAngryBalls.controlerEtatcourant = suivant;
            Bille bille;
            Object object;
            if( (bille = OutilsBille.clickSurUneBille(arg0.getX(), arg0.getY(), cadreAngryBalls.billard.billes)) != null) {
                if( (object = bille.getMvt(MvtAttrapable.class)) != null) {
                    cadreAngryBalls.attrapableVecteur = ((MvtAttrapable) object).getAttraction();
                    cadreAngryBalls.controlerEtatcourant = suivant;
                }
            }
        }
    }

    @Override
    public void traiterDrag(MouseEvent arg0, Bille bille, Vector<Bille> billes) {

    }

    @Override
    public String toString() {
        return "ControlerAttraper";
    }
}
