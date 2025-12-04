package Projekat5;

abstract class Enemy extends GameObject implements Attacker {
    protected String type;
    protected int damage;
    protected int health;
    
    public Enemy(String type, int damage, int health, int x, int y, Collidable collider) {
        super(x, y, collider);
        this.type = type;
        if (damage < 0 || damage > 100) {
            throw new IllegalArgumentException("Damage mora biti 0-100");
        }
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Health mora biti 0-100");
        }
        this.damage = damage;
        this.health = health;
    }
    
    public String getType() { return type; }
    public int getDamage() { return damage; }
    public int getHealth() { return health; }
    
    @Override
    public String getDisplayName() {
        return type;
    }
    
    @Override
    public String toString() {
        return type + " (damage: " + damage + ", health: " + health + ") at (" + getX() + ", " + getY() + ")";
    }
}

