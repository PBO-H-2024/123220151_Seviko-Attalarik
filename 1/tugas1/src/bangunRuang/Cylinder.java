package bangunRuang;

import bangunDatar.Circle;

public class Cylinder extends Circle implements BangunRuang {
    double height;

    public Cylinder(double r, double height) {
        super(r);
        this.height = height;
    }

    public double volume() {
        return area() * height;
    }

    public double cArea() {
        return 2 * area() + circumference() * height;
    }

    @Override
    public double TPArea() {
        return 0;
    }

}
