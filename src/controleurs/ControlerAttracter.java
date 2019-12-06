package controleurs;

import mesmaths.geometrie.base.Vecteur;

import java.awt.event.MouseEvent;

public class ControlerAttracter extends ControlerEtat {
    Vecteur precPosCurseur;

    public ControlerAttracter(ControleurAttrapeur controleurAttrapeur, ControlerEtat suivant) {
        super(controleurAttrapeur, suivant);
    }

    @Override
    public void traiter(MouseEvent arg0) {
        if (arg0.getID() == MouseEvent.MOUSE_RELEASED) {
            //Lancer la boule
            controleurAttrapeur.billeAttrapable.directionCurseur = null;
            controleurAttrapeur.controlerEtatcourant = suivant;
            return;
        }

        Vecteur curseur = new Vecteur(arg0.getX(), arg0.getY());

        controleurAttrapeur.billeAttrapable.directionCurseur = curseur.difference(precPosCurseur);

        precPosCurseur = curseur;
    }

    @Override
    public String toString() {
        return "ControlerAttracter";
    }
}
