package modele;

import javafx.embed.swing.JFXPanel;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.HashMap;

public class SoundPlayer implements Sound{

    static {
        JFXPanel fxPanel = new JFXPanel(); //Initialise des composants JavaFx nécessaire à MediaPlayer
    }

    static HashMap<String, Media> hashMap = new HashMap<String, Media>();; //Permet le stockage des medias <CheminRelatif, Media>
    static ClassLoader cl = ClassLoader.getSystemClassLoader(); //Permet d'obtenir le chemin jusqu'au projet

    public SoundPlayer() {}

    public void playSound(String sound) {
        playSound(sound, 0, 1);
    }

    /**Crée le media vers le son, l'enregistre pour les prochaines utilisation
     * et le joue
     * @param sound Le chemin relatif au fichier
     * @param balance le balancement du son, de gauche a droite [-1.0, 1.0]
     * @param volume le volume [0.0, 1.0]
     */
    public void playSound(String sound, double balance, double volume) {
        Media media = hashMap.get(sound);
        if(media == null) {
            URL soundPath = cl.getResource(sound);
            if (soundPath == null) {
                System.out.println("Le fichier audio " + sound + " est introuvable,\n sagit-il bien d'un chemin relatif ?");
                return;
            }
            media = new Media(soundPath.toString());
            hashMap.put(sound, media);
        }
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.balanceProperty().setValue(balance);
        mediaPlayer.setVolume(volume);
        mediaPlayer.play();
    }

    public HashMap getHashMap() {
        return hashMap;
    }
}
