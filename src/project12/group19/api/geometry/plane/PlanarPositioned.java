package project12.group19.api.geometry.plane;

public interface PlanarPositioned {
    PlanarCoordinate getPosition();

    default double getX() {
        return getPosition().getX();
    }

    default double getY() {
        return getPosition().getY();
    }
}
