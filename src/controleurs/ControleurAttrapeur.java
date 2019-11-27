package controleurs;

import mesmaths.geometrie.base.Vecteur;
import modele.MvtAttrapable;
import vues.CadreAngryBalls;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ControleurAttrapeur implements MouseListener, MouseMotionListener {
    ControlerEtat controlerEtatcourant;
    CadreAngryBalls cadre;
    MvtAttrapable billeAttrapable;
    private ControlerAttraper controlerAttraper;
    private ControlerAttracter controlerAttracter;

    public ControleurAttrapeur(CadreAngryBalls cadre) {
        this.cadre = cadre;

        cadre.billard.addMouseListener(this);
        cadre.billard.addMouseMotionListener(this);

        installeControleur();
    }

    private void installeControleur() {
        controlerAttraper = new ControlerAttraper(this, null);
        controlerAttracter = new ControlerAttracter(this, controlerAttraper);

        controlerAttraper.suivant = controlerAttracter;

        controlerEtatcourant = controlerAttraper;
    }


    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        controlerEtatcourant.traiter(e);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        controlerEtatcourant.suivant.precPosCurseur = new Vecteur(e.getX(), e.getY());
        controlerEtatcourant.traiter(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        controlerEtatcourant.traiter(e);
    }


    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
