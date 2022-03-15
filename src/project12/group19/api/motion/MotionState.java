package project12.group19.api.motion;

public interface MotionState {
    double getXSpeed();
    double getYSpeed();
    double getXPosition();
    double getYPosition();

    record Standard(
            double xSpeed,
            double ySpeed,
            double xPosition,
            double yPosition
    ) implements MotionState {
        @Override
        public double getXSpeed() {
            return xSpeed;
        }

        @Override
        public double getYSpeed() {
            return ySpeed;
        }

        @Override
        public double getXPosition() {
            return xPosition;
        }

        @Override
        public double getYPosition() {
            return yPosition;
        }
    }
}
