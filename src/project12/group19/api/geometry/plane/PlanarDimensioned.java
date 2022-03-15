package project12.group19.api.geometry.plane;

public interface PlanarDimensioned {
    PlanarDimensions getDimensions();

    default double getWidth() {
        return getDimensions().getWidth();
    }

    default double getHeight() {
        return getDimensions().getHeight();
    }
}
