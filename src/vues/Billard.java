package vues;

import modele.Bille;

import java.awt.*;
import java.util.Vector;


/**
 * responsable du dessin des billes
 * <p>
 * ICI : IL N'Y A RIEN A CHANGER
 */
public class Billard extends Canvas {
    public Vector<Bille> billes;

    public Billard(Vector<Bille> billes) {
        this.billes = billes;
    }

    /* (non-Javadoc)
     * @see java.awt.Canvas#paint(java.awt.Graphics)
     */
    @Override
    public void paint(Graphics graphics) {
        int i;

        for (i = 0; i < this.billes.size(); ++i)
            this.billes.get(i).dessine(graphics);

        //System.out.println("billes dans le billard = " + billes);
    }


}
