package bangunDatar;

public class Triangle implements BangunDatar {
    public double base, sideA, sideB;

    public Triangle(double base, double sideA, double sideB) {
        this.base = base;
        this.sideA = sideA;
        this.sideB = sideB;
    }

    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s*(s - base) * (s - sideA) * (s - sideB));
    }

    public double perimeter() {
        return base + sideA + sideB;
    }

    @Override
    public double circumference() {
        return 0;
    }
}
