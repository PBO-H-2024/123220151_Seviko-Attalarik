package bangunDatar;

public class Circle implements BangunDatar {
    public double pi = Math.PI, radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return pi * Math.pow(radius, 2);
    }

    public double circumference() {
        return 2* pi * radius;
    }

    @Override
    public double perimeter() {
        return 0;
    }
}
