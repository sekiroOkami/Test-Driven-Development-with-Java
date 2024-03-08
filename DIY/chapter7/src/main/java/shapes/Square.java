package shapes;

public class Square implements Shape {
    int side;

    public Square(int side) {
        this.side = side;
    }

    @Override
    public int area() {
        return side * side;
    }
}
