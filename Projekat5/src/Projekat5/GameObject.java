package Projekat5;

public abstract class GameObject {
    private int x;
    private int y;
    private Collidable collider;
    
    public GameObject(int x, int y, Collidable collider) {
        if (x < 0 || y < 0) {
            throw new IllegalArgumentException("Pozicija ne moze biti negativna");
        }
        this.x = x;
        this.y = y;
        this.collider = collider;
    }
    
    public int getX() { return x; }
    public void setX(int x) { 
        if (x < 0) throw new IllegalArgumentException("X ne moze biti negativan");
        this.x = x; 
    }
    
    public int getY() { return y; }
    public void setY(int y) { 
        if (y < 0) throw new IllegalArgumentException("Y ne moze biti negativan");
        this.y = y; 
    }
    
    public Collidable getCollider() { return collider; }
    
    public boolean intersectsGameObject(GameObject other) {
        return collider.intersectsCollidable(other.getCollider());
    }
    
    public abstract String getDisplayName();
    
    @Override
    public String toString() {
        return "GameObject at (" + x + ", " + y + ")";
    }
}

