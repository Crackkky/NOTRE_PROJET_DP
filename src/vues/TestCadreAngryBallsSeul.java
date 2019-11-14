package vues;

import modele.Bille;

import java.util.Vector;


public class TestCadreAngryBallsSeul {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Vector<Bille> billes = new Vector<Bille>();
        CadreAngryBalls cadre = new CadreAngryBalls("angry balls", "animation de billes marrantes", billes);
        cadre.montrer();
    }

}
