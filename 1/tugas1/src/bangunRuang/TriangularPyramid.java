package bangunRuang;

import bangunDatar.Triangle;

public class TriangularPyramid extends Triangle implements BangunRuang {
    double pyramidHeight;
    public TriangularPyramid (double b, double h, double pyramidHeight) {
        super(b, h);
        this.pyramidHeight = pyramidHeight;
    }

    public double volume() {
        return 1.0 / 3.0 * area() * pyramidHeight;
    }

    public double TPArea() {
        return area() * 4;
    }

    @Override
    public double cArea() {
        return 0;
    }
}
