package project12.group19.api.domain;

import project12.group19.api.motion.MotionState;

/**
 * Contains current game state.
 */
public interface State {
    Course getCourse();
    MotionState getBallState();
    boolean isTerminal();
    boolean isStatic();
    int getHits();
    int getFouls();
}
