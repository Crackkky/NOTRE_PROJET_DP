package mesmaths.cinematique;

import mesmaths.geometrie.base.Vecteur;

public class Cinematique {
    /**
     * suppose qu'un objet mobile subit un mouvement rectiligne uniforme (c'à-d un deplacement en ligne droite à vitesse constante)
     * <p>
     * le mouvement de l'objet est à tout instant defini par le vecteur position et le vecteur vitesse.
     * <p>
     * DONNEES : position et vitesse à l'instant t, deltaT (deltaT est le delai entre 2 mises à jour, deltaT est suppose petit)
     * <p>
     * RESULTATS : position à l'instant t + deltaT
     * <p>
     * vitesse est laisse inchange par la methode
     * <p>
     * <p>
     * Le calcul peut être note comme suit :
     * <p>
     * p(t+deltaT) = p(t) + deltaT * v(t)
     * v(t+deltaT) = v(t)
     */
    private static void mouvementRectiligneUniforme(Vecteur position, Vecteur vitesse, double deltaT) {
        position.ajoute(vitesse.produit(deltaT));
    }

    /**
     * suppose qu'un objet mobile subit un mouvement uniformement accelere entre t et t+deltaT (c'à-d un deplacement comme la chute libre)
     * <p>
     * le mouvement de l'objet est à tout instant defini par le vecteur position, le vecteur vitesse et le vecteur acceleration
     * <p>
     * DONNEES : position, vitesse et acceleration à l'instant t, deltaT (deltaT est le delai entre 2 mises à jour, deltaT est suppose petit)
     * <p>
     * RESULTATS : position et  vitesse  à l'instant t + deltaT.
     * <p>
     * acceleration reste inchange par la methode. Il faudra le recalculer  l'instant t+deltaT avec une autre methode
     * <p>
     * <p>
     * * Les calculs peuvent être notes comme suit :
     * <p>
     * p(t+deltaT) = p(t) + deltaT * v(t) + (1/2) * deltaT^2 * a(t)
     * v(t+deltaT) = v(t) + deltaT * a(t)
     * a(t + deltaT) = a(t)
     *
     * @param position     : vecteur position du mobile à l'instant t. ce paramètre est modifie par la methode : en sortie il represente la position à l'instant t+deltaT
     * @param vitesse      : vecteur vitesse du mobile à l'instant t. ce paramètre est modifie par la methode : en sortie il represente la vitesse à l'instant t+deltaT
     * @param acceleration : vecteur acceleration du mobile à l'instant t
     * @param deltaT       : une duree très courte
     */
    public static void mouvementUniformementAccelere(Vecteur position, Vecteur vitesse, Vecteur acceleration, double deltaT) {
        mouvementRectiligneUniforme(position, vitesse, deltaT);
        position.ajoute(acceleration.produit(0.5 * deltaT * deltaT));
        mouvementRectiligneUniforme(vitesse, acceleration, deltaT);
//acceleration.set(Vecteur.VECTEURNUL);
    }
}
