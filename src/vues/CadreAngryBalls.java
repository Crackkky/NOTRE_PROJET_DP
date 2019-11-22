package vues;

import mesmaths.geometrie.base.Vecteur;
import modele.*;
import modele.Bille;
import modele.OutilsBille;
import outilsvues.EcouteurTerminaison;
import outilsvues.Outils;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

/**
 * Vue dessinant les billes et contenant les 3 boutons de contrele (arret du programme, lancer les billes, arreter les billes)
 * <p>
 * ICI : IL N'Y A RIEN A CHANGER
 */
public class CadreAngryBalls extends Frame implements VueBillard, MouseListener, MouseMotionListener {
    public Button lancerBilles, arreterBilles;
    TextField presentation;
    Billard billard;
    Panel haut, centre, bas;

    EcouteurTerminaison ecouteurTerminaison;

    ControlerAttraper controlerAttraper;
    ControlerAttracter controlerAttracter;
    ControlerEtat controlerEtatcourant;

    Vecteur attrapableVecteur;

    public CadreAngryBalls(String titre, String message, Vector<Bille> billes) throws HeadlessException {
        super(titre);
        Outils.place(this, 0.33, 0.33, 0.5, 0.5);
        this.ecouteurTerminaison = new EcouteurTerminaison(this);


        this.haut = new Panel();
        this.haut.setBackground(Color.LIGHT_GRAY);
        this.add(this.haut, BorderLayout.NORTH);

        this.centre = new Panel();
        this.add(this.centre, BorderLayout.CENTER);

        this.bas = new Panel();
        this.bas.setBackground(Color.LIGHT_GRAY);
        this.add(this.bas, BorderLayout.SOUTH);

        this.presentation = new TextField(message, 100);
        this.presentation.setEditable(false);
        this.haut.add(this.presentation);

        this.billard = new Billard(billes);
        this.add(this.billard);

        this.lancerBilles = new Button("lancer les billes");
        this.bas.add(this.lancerBilles);
        this.arreterBilles = new Button("arreter les billes");
        this.bas.add(this.arreterBilles);

        billard.addMouseListener(this);
        billard.addMouseMotionListener(this);

        installeControleur();
    }

    private void installeControleur() {
        controlerAttraper = new ControlerAttraper(this, null);
        controlerAttracter = new ControlerAttracter(this, controlerAttraper);

        controlerAttraper.suivant = controlerAttracter;

        controlerEtatcourant = controlerAttraper;
    }

    public double largeurBillard() {
        return this.billard.getWidth();
    }

    public double hauteurBillard() {
        return this.billard.getHeight();
    }

    @Override
    public void miseAJour() {
        this.billard.repaint();
    }

    @Override
    public void montrer() {
        this.setVisible(true);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        System.out.println("Mouse Drag");

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Press");
//
//        Bille bille = OutilsBille.clickSurUneBille(e.getX(), e.getY(), billard.billes);
//
//        System.out.println("Mouse Press");
//
//
////        MvtAttrapable billeAttrapable = (MvtAttrapable) bille.getMvt(MvtAttrapable.class);
////        System.out.println("Bille attrapable? " + billeAttrapable.estAttrapable());
//
//        if (bille != null) {
////            System.out.println("Bille attrapee avant? " + bille.attrapee);
//
////            MvtAttrapable billeAttrapable = (MvtAttrapable) bille.getMvt(MvtAttrapable.class);
////            System.out.println("Bille attrapable? " + billeAttrapable.estAttrapable());
//
//            controlerEtatcourant.traiter(e, bille);
////            System.out.println("Bille attrapee apres? " + bille.attrapee);
//            System.out.println(" ");
//        }
        controlerEtatcourant.traiter(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
//        System.out.println("Mouse Release");
//
//        Bille bille = OutilsBille.billeAttrapable(billard.billes);
//
//        if (bille != null && bille.attrapee) {
//            System.out.println("Bille attrapee avant? " + bille.attrapee);
//            System.out.println(bille);
//
//            controlerEtatcourant.traiter(e, bille);
//
//            System.out.println("Bille attrapee apres? " + bille.attrapee);
//            System.out.println(" ");
//        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}