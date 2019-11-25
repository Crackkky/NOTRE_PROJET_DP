package vues;

import mesmaths.geometrie.base.Vecteur;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class ControlerAttracter extends ControlerEtat{

    public ControlerAttracter(CadreAngryBalls cadreAngryBalls, ControlerEtat suivant) {
        super(cadreAngryBalls, suivant);
    }

    @Override
    public void traiter(MouseEvent arg0) {
        Vecteur v_bille = cadreAngryBalls.billeAttrapable.getPosition(),
                attrapableVecteur = cadreAngryBalls.attrapableVecteur;
        attrapableVecteur.x = (v_bille.x + arg0.getX())/2;
        attrapableVecteur.y = (v_bille.y + arg0.getY())/2; // Vecteur de la boule vers la sourie
        if (arg0.getID() == MouseEvent.MOUSE_RELEASED) {
            attrapableVecteur = null;
            cadreAngryBalls.controlerEtatcourant = suivant;
        }
    }
}
