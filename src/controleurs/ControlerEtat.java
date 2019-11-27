package controleurs;

import mesmaths.geometrie.base.Vecteur;

import java.awt.event.MouseEvent;

public abstract class ControlerEtat {
    public ControleurAttrapeur controleurAttrapeur;
    public ControlerEtat suivant;
    Vecteur precPosCurseur;

    public ControlerEtat(ControleurAttrapeur controleurAttrapeur, ControlerEtat suivant) {
        this.controleurAttrapeur = controleurAttrapeur;
        this.suivant = suivant;
    }

    public abstract void traiter(MouseEvent arg0);
}
