package projekat_cas_drugi_oktobar;

import java.util.Scanner;

//Petar Raičević 22/053
//Merjem Luković 24/051
//Arijana Bajramović 24/011

import java.util.Scanner;

class Player {
    int x, y, width, height, health;

    Player(int x, int y, int width, int height, int health) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.health = Math.max(0, Math.min(health, 100)); 
    }
}

class Enemy {
    int x, y, width, height, damage;

    Enemy(int x, int y, int width, int height, int damage) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.damage = Math.max(0, Math.min(damage, 100)); 
    }
}

public class zadatak {

    static boolean checkCollision(Player p, Enemy e) {
        return p.x < e.x + e.width &&
               p.x + p.width > e.x &&
               p.y < e.y + e.height &&
               p.y + p.height > e.y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Unesi podatke za Player-a (x y width height health):");
        Player p = new Player(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
        
        System.out.println("Unesi podatke za Enemy-a (x y width height damage):");
        Enemy e = new Enemy(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());

        System.out.println("Health prije sudara: " + p.health);

        if (checkCollision(p, e)) {
            p.health -= e.damage;
            if (p.health < 0) p.health = 0; 
            System.out.println("Došlo je do sudara!");
        } else {
            System.out.println("Nema sudara.");
        }

        System.out.println("Health poslije sudara: " + p.health);
    }
}
