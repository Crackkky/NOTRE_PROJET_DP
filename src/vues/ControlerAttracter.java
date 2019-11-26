package vues;

import mesmaths.geometrie.base.Vecteur;

import java.awt.event.MouseEvent;

public class ControlerAttracter extends ControlerEtat {

    public ControlerAttracter(CadreAngryBalls cadreAngryBalls, ControlerEtat suivant) {
        super(cadreAngryBalls, suivant);
    }

    @Override
    public void traiter(MouseEvent arg0) {
        cadreAngryBalls.billeAttrapable.coordCurseur = new Vecteur(arg0.getX(), arg0.getY());
        cadreAngryBalls.billeAttrapable.precCoordCurseur = new Vecteur(precPosCurseur.x, precPosCurseur.y);


//        System.out.println("X : " + cadreAngryBalls.billeAttrapable.coordCurseur.x/1000 + "Y : " + cadreAngryBalls.billeAttrapable.coordCurseur.y/1000);
        precPosCurseur = new Vecteur(arg0.getX(), arg0.getY());

        if (arg0.getID() == MouseEvent.MOUSE_RELEASED) {
            //Lancer la boule
            cadreAngryBalls.billeAttrapable.coordCurseur = null;
            cadreAngryBalls.controlerEtatcourant = suivant;
        }
    }

    @Override
    public String toString() {
        return "ControlerAttracter";
    }
}
