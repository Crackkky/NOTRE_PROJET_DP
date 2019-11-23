package vues;

import modele.Bille;
import modele.MvtAttrapable;
import modele.OutilsBille;

import java.awt.event.MouseEvent;

public class ControlerAttraper extends ControlerEtat {

    public ControlerAttraper(CadreAngryBalls cadreAngryBalls, ControlerEtat suivant) {
        super(cadreAngryBalls, suivant);
    }

    @Override
    public void traiter(MouseEvent arg0) {
        if (arg0.getButton() == MouseEvent.BUTTON1) {
            Bille bille;
            Object object;
            if ((bille = OutilsBille.clickSurUneBille(arg0.getX(), arg0.getY(), cadreAngryBalls.billard.billes)) != null) {
                System.out.println("Bille cliquee : " + bille);

                System.out.println(bille.getMvt(MvtAttrapable.class));
                if ((object = bille.getMvt(MvtAttrapable.class)) != null) {
                    System.out.println("Attrapee !");

                    cadreAngryBalls.billeAttrapable = (MvtAttrapable) object;
                    cadreAngryBalls.controlerEtatcourant = suivant;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ControlerAttraper";
    }
}
