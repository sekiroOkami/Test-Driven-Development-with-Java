package shapes;

public class Rectangle implements Shape {
    int width;
    int height;

    @Override
    public int area() {
        return width * height;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
