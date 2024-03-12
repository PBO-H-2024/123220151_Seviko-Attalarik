package bangunDatar;

public class Triangle implements BangunDatar {
    public double base, height;

    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    public double area() {
        return 0.5 * base * height;
    }

    public double perimeter() {
        double side = Math.sqrt(Math.pow(0.5 * base, 2) + Math.pow(height, 2));
        return side * 2 + base;
    }

    @Override
    public double circumference() {
        return 0;
    }
}
