package vues;

import mesmaths.geometrie.base.Vecteur;
import java.awt.event.MouseEvent;

public class ControlerAttracter extends ControlerEtat{

    public ControlerAttracter(CadreAngryBalls cadreAngryBalls, ControlerEtat suivant) {
        super(cadreAngryBalls, suivant);
    }

    @Override
    public void traiter(MouseEvent arg0) {
        Vecteur v_bille = cadreAngryBalls.billeAttrapable.getPosition(),
                attrapableVecteur = cadreAngryBalls.attrapableVecteur;
        attrapableVecteur.set(new Vecteur(0, -0.01)); // TODO bien calculer ici le vecteur de l'attraction, ou peut etre le faire dans MVTAttrapable, comme pour les autres ? Non ?
        if (arg0.getID() == MouseEvent.MOUSE_RELEASED) {
            //Lancer la boule
            attrapableVecteur.set(new Vecteur());
            cadreAngryBalls.controlerEtatcourant = suivant;
        }
    }
}
