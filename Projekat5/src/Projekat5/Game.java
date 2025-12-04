package Projekat5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private Player player;
    private ArrayList<Enemy> enemies;
    private ArrayList<String> log;
    
    public Game(Player player) {
        this.player = player;
        this.enemies = new ArrayList<>();
        this.log = new ArrayList<>();
    }
    
    public void addEnemy(Enemy e) {
        enemies.add(e);
        log.add("Dodan neprijatelj: " + e.getDisplayName());
    }
    
    public boolean checkCollision(Player p, Enemy e) {
        return p.intersectsGameObject(e);
    }
    
    public void decreaseHealth(Player p, Enemy e) {
        int damage = e.getEffectiveDamage();
        p.setHealth(p.getHealth() - damage);
        log.add(p.getDisplayName() + " izgubio " + damage + " health od " + e.getDisplayName() + 
                ". Novo health: " + p.getHealth());
    }
    
    public List<Enemy> findByType(String query) {
        ArrayList<Enemy> result = new ArrayList<>();
        for (Enemy e : enemies) {
            if (e.getType().toLowerCase().contains(query.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }
    
    public List<Enemy> collidingWithPlayer() {
        ArrayList<Enemy> colliding = new ArrayList<>();
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                colliding.add(e);
            }
        }
        return colliding;
    }
    
    public void resolveCollisions() {
        for (Enemy e : enemies) {
            if (checkCollision(player, e)) {
                decreaseHealth(player, e);
            }
        }
    }
    
    public static ArrayList<Enemy> loadEnemiesFromCSV(String filePath) {
    	
        ArrayList<Enemy> enemies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
        	String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length < 7) continue;
                
                String type = parts[0].trim();
                String enemyClass = parts[1].trim();
                int damage = Integer.parseInt(parts[2].trim());
                int health = Integer.parseInt(parts[3].trim());
                int x = Integer.parseInt(parts[4].trim());
                int y = Integer.parseInt(parts[5].trim());
                String shape = parts[6].trim();
                
                Collidable collider;
                if (shape.equals("rectangle")) {
                    int width = Integer.parseInt(parts[7].trim());
                    int height = Integer.parseInt(parts.length > 8 ? parts[8].trim() : "32");
                    collider = new RectangleCollider(x, y, width, height);
                } else {
                    int radius = Integer.parseInt(parts[7].trim());
                    collider = new CircleCollider(x, y, radius);
                }
                
                Enemy enemy;
                if (enemyClass.equals("melee")) {
                    enemy = new MeleeEnemy(type, damage, health, x, y, collider);
                } else if (enemyClass.equals("boss")) {
                    enemy = new BossEnemy(type, damage, health, x, y, collider);
                } else {
                    throw new IllegalArgumentException("Nepoznata klasa: " + enemyClass);
                }
                enemies.add(enemy);
            }
        } catch (IOException | NumberFormatException e) {
            throw new IllegalArgumentException("Greska pri citanju CSV: " + e.getMessage());
        }
        return enemies;
    }
    
    public String getGameStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== PLAYER ===\n");
        sb.append(player.toString()).append("\n\n");
        
        sb.append("=== SVI NEPRIJATELJI ===\n");
        for (Enemy e : enemies) {
            sb.append(e.toString()).append("\n");
        }
        sb.append("\n");
        
        sb.append("=== U KOLIZIJI ===\n");
        List<Enemy> colliding = collidingWithPlayer();
        for (Enemy e : colliding) {
            sb.append(e.toString()).append("\n");
        }
        sb.append("\n");
        
        sb.append("=== LOG ===\n");
        for (String event : log) {
            sb.append(event).append("\n");
        }
        return sb.toString();
    }
    
    public boolean isGameOver() {
        return player.getHealth() <= 0;
    }
}

