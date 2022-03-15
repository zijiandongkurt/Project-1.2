package project12.group19.api.game;

import project12.group19.api.domain.Item;
import project12.group19.api.geometry.space.HeightProfile;
import project12.group19.api.motion.Friction;
import project12.group19.api.motion.MotionState;

import java.util.Set;

public interface Configuration {
    HeightProfile getHeightProfile();
    Set<Item> getObstacles();
    MotionState getInitialMotion();
    Friction getGroundFriction();
    Friction getSandFriction();

    record Standard(
            HeightProfile heightProfile,
            Set<Item> obstacles,
            MotionState initialMotion,
            Friction groundFriction,
            Friction sandFriction
    ) implements Configuration {
        @Override
        public HeightProfile getHeightProfile() {
            return heightProfile;
        }

        @Override
        public Set<Item> getObstacles() {
            return obstacles;
        }

        @Override
        public MotionState getInitialMotion() {
            return initialMotion;
        }

        @Override
        public Friction getGroundFriction() {
            return groundFriction;
        }

        @Override
        public Friction getSandFriction() {
            return sandFriction;
        }
    }
}
