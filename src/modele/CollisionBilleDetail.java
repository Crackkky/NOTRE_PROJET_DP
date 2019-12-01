package modele;

public class CollisionBilleDetail {
    public Bille bille1;
    public Bille bille2;
    public CollisionDetail collisionDetail;

    public CollisionBilleDetail(Bille bille1, Bille bille2, CollisionDetail collisionDetail) {
        this.bille1 = bille1;
        this.bille2 = bille2;
        this.collisionDetail = collisionDetail;
    }
}
