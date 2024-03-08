package shapes;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = {new Rectangle(3,4), new Square(5)};
        int totalArea = sumOfArea(shapes);
        System.out.println("totalArea = " + totalArea); // output : total area : 31
    }
    static int sumOfArea(Shape... shapes) {
        int sum = 0;
        for (Shape shape: shapes) {
            sum += shape.area();
        }
        return sum;
    }
}
