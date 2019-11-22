package vues;

import modele.Bille;
import modele.MvtAttrapable;
import modele.OutilsBille;

import java.awt.event.MouseEvent;

public class ControlerAttraper extends ControlerEtat{

    public ControlerAttraper(CadreAngryBalls cadreAngryBalls, ControlerEtat suivant) {
        super(cadreAngryBalls, suivant);
    }

    @Override
    public void traiter(MouseEvent arg0) {
        if(arg0.getButton() == MouseEvent.BUTTON1) {
            Bille bille;
            Object object;
            if( (bille = OutilsBille.clickSurUneBille(arg0.getX(), arg0.getY(), cadreAngryBalls.billard.billes)) != null) {
                if( (object = bille.getMvt(MvtAttrapable.class)) != null) {
                    cadreAngryBalls.billeAttrapable = bille;
                    cadreAngryBalls.attrapableVecteur = ((MvtAttrapable) object).getAttraction();
                    cadreAngryBalls.controlerEtatcourant = suivant;
                }
            }
        }
    }
}
