package project12.group19.api.domain;

import project12.group19.api.geometry.plane.PlanarCoordinate;

public interface Item {
    String getType();
    PlanarCoordinate getCoordinate();
}
