package Projekat5;

public class CircleCollider implements Collidable {
    private int x, y, radius;

    public CircleCollider(int x, int y, int radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius mora biti pozitivan");
        }
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    private int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    @Override
    public boolean intersectsCollidable(Collidable other) {
        if (other instanceof CircleCollider) {
            CircleCollider circle = (CircleCollider) other;
            int dx = this.x - circle.x;
            int dy = this.y - circle.y;
            int distance = (int) Math.sqrt(dx * dx + dy * dy);
            return distance <= (this.radius + circle.radius);
        } else {
            RectangleCollider rect = (RectangleCollider) other;
            int closestX = clamp(this.x, rect.getX(), rect.getX() + rect.getWidth());
            int closestY = clamp(this.y, rect.getY(), rect.getY() + rect.getHeight());
            int dx = this.x - closestX;
            int dy = this.y - closestY;
            int distance = (int) Math.sqrt(dx * dx + dy * dy);
            return distance <= this.radius;
        }
    }
}


