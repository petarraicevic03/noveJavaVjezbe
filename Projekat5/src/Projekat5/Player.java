package Projekat5;

class Player extends GameObject {
    private String name;
    private int health;
    
    public Player(String name, int health, int x, int y, Collidable collider) {
        super(x, y, collider);
        if (name == null || name.trim().isEmpty() || !Character.isUpperCase(name.charAt(0))) {
            throw new IllegalArgumentException("Ime mora početi velikim slovom");
        }
        if (health < 0 || health > 100) {
            throw new IllegalArgumentException("Health mora biti 0-100");
        }
        this.name = name.trim();
        this.health = health;
    }
    
    public String getName() { return name; }
    public int getHealth() { return health; }
    public void setHealth(int health) {
        if (health < 0) health = 0;
        if (health > 100) health = 100;
        this.health = health;
    }
    
    @Override
    public String getDisplayName() {
        return name;
    }
    
    @Override
    public String toString() {
        return "Player " + name + " (health: " + health + ") at (" + getX() + ", " + getY() + ")";
    }
}

