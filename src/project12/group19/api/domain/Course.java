package project12.group19.api.domain;

import project12.group19.api.geometry.space.HeightProfile;

import java.util.Set;

/**
 * Describes the played golf course.
 */
public interface Course {
    HeightProfile getSurface();
    Item getBall();
    Set<Item> getObstacles();
}
