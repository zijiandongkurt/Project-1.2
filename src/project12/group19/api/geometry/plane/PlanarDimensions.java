package project12.group19.api.geometry.plane;

public interface PlanarDimensions {
    double getWidth();
    double getHeight();

    static PlanarDimensions create(double width, double height) {
        return new Standard(width, height);
    }

    record Standard(double width, double height) implements PlanarDimensions {
        @Override
        public double getWidth() {
            return width;
        }

        @Override
        public double getHeight() {
            return height;
        }
    }
}
