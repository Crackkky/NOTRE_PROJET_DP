package controleurs;

import modele.Bille;
import modele.MvtAttrapable;
import modele.OutilsBille;

import java.awt.event.MouseEvent;

public class ControlerAttraper extends ControlerEtat {

    public ControlerAttraper(ControleurAttrapeur controleurAttrapeur, ControlerEtat suivant) {
        super(controleurAttrapeur, suivant);
    }

    @Override
    public void traiter(MouseEvent arg0) {
        if (arg0.getButton() == MouseEvent.BUTTON1) {
            Bille bille;
            Object object;
            if ((bille = OutilsBille.clickSurUneBille(arg0.getX(), arg0.getY(), controleurAttrapeur.cadre.billard.billes)) != null) {
                System.out.println("Bille cliquee : " + bille);

                System.out.println(bille.getMvt(MvtAttrapable.class));
                if ((object = bille.getMvt(MvtAttrapable.class)) != null) {

                    controleurAttrapeur.billeAttrapable = (MvtAttrapable) object;
                    controleurAttrapeur.controlerEtatcourant = suivant;
                }
            }
        }
    }

    @Override
    public String toString() {
        return "ControlerAttraper";
    }
}
