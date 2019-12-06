package controleurs;

import modele.Bille;
import modele.MvtAttrapable;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

public class ControleurAttrapeur implements MouseListener, MouseMotionListener {
    Vector<Bille> billes;
    MvtAttrapable billeAttrapable;

    ControlerEtat controlerEtatcourant;
    ControlerAttraper controlerAttraper;
    ControlerAttracter controlerAttracter;

    public ControleurAttrapeur(Vector<Bille> billes) {
        this.billes = billes;

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
