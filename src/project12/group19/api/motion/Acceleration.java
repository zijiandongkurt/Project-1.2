package project12.group19.api.motion;

import project12.group19.api.geometry.space.HeightProfile;

/**
 * A special container which is derived for specific point using
 * {@link HeightProfile} to pass it into {@link MotionCalculator} -
 * this allows to prevent repetition of calculating it inside different
 * calculators.
 */
public interface Acceleration {
    double getX();
    double getY();
}
