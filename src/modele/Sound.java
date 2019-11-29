package modele;

public interface Sound {
    /**
     * @param sound Le chemin relatif au fichier
     * @param balance le balancement du son
     * @param volume le volume
     */
    public void playSound(String sound, double balance, double volume);

}
