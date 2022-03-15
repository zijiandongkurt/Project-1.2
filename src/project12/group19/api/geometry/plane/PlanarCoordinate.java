package project12.group19.api.geometry.plane;

public interface PlanarCoordinate {
    double getX();
    double getY();

    static PlanarCoordinate create(double x, double y) {
        return new Standard(x, y);
    }

    record Standard(double x, double y) implements PlanarCoordinate {
        @Override
        public double getX() {
            return x;
        }

        @Override
        public double getY() {
            return y;
        }
    }
}
