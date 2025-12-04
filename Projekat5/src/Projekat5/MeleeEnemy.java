package Projekat5;

public class MeleeEnemy extends Enemy {
    public MeleeEnemy(String type, int damage, int health, int x, int y, Collidable collider) {
        super(type, damage, health, x, y, collider);
    }
    
    @Override
    public int getEffectiveDamage() {
        return damage;
    }
}

