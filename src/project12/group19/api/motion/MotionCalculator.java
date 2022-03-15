package project12.group19.api.motion;

public interface MotionCalculator {
    /**
     * Takes current motion state and calculates the next at moment of
     * time {@code currentTime + deltaT}.
     *
     * @param state Current item state.
     * @param acceleration Precomputed x/y acceleration for the specific
     * point set in {@param state}. Kept outside of calculator to
     * prevent repetition since this value would be the same for all
     * calculator implementations.
     * @param deltaT Number of seconds (fraction of second) "in future"
     * relative to current state at which next state should be computed.
     * @return New motion state for this specific item.
     */
    MotionState calculate(MotionState state, Acceleration acceleration, double deltaT);
}
