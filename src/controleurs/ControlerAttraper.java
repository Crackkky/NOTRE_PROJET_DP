package controleurs;

import mesmaths.geometrie.base.Vecteur;
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
            if ((bille = OutilsBille.clickSurUneBille(arg0.getX(), arg0.getY(), controleurAttrapeur.billes)) != null) {
                if ((object = bille.getMvt(MvtAttrapable.class)) != null) {
                    controleurAttrapeur.controlerAttracter.precPosCurseur = new Vecteur(arg0.getX(), arg0.getY());
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
