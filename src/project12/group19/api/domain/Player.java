package project12.group19.api.domain;

import java.util.Optional;

/**
 * Describes a player. On each tick when ball is stable player is asked
 * whether to make a hit, which it can either do (by returning a filled
 * optional) or refuse to (by returning empty optional).
 */
public interface Player {
    Optional<Hit> play(Course course);

    interface Hit {
        double getXVelocity();
        double getYVelocity();
    }
}
