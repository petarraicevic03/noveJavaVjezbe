package Projekat5;

public class RectangleCollider implements Collidable {
    private int x, y, width, height;

    public RectangleCollider(int x, int y, int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Dimenzije moraju biti pozitivne");
        }
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }

    @Override
    public boolean intersectsCollidable(Collidable other) {
        if (other instanceof RectangleCollider) {
            RectangleCollider rect = (RectangleCollider) other;
            return !(this.x + this.width < rect.x ||
                     rect.x + rect.width < this.x ||
                     this.y + this.height < rect.y ||
                     rect.y + rect.height < this.y);
        } else {
            CircleCollider circle = (CircleCollider) other;
            return circle.intersectsCollidable(this);
        }
    }
}

