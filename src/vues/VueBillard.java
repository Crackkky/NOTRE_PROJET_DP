package vues;


/**
 * contrat respecte par toute vue capable de dessiner la liste des billes
 * <p>
 * Comme ea si vous n'aimez pas mes composants awt vous pouvez les changer sans changer le reste de l'appli
 * <p>
 * ICI : IL N'Y A RIEN A CHANGER
 */
public interface VueBillard {

    public double largeurBillard();

    public double hauteurBillard();

    public void miseAJour();

    public void montrer();
}
