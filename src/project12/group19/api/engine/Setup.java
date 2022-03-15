package project12.group19.api.engine;

import project12.group19.api.domain.Player;
import project12.group19.api.domain.State;
import project12.group19.api.game.Configuration;
import project12.group19.api.motion.MotionCalculator;

import java.util.List;
import java.util.function.Consumer;

public interface Setup {
    Configuration getConfiguration();

    /**
     * @return Number of times per second engine calculates game state.
     * Bigger values result in improved accuracy and increased CPU
     * consumption.
     */
    int getDesiredTickRate();

    /**
     * @return Number of times per second UI should be refreshed. May be
     * bounded by sane values (e.g. max 60Hz).
     */
    int getDesiredRefreshRate();

    /**
     * @return Calculator used to update ball position.
     */
    MotionCalculator getMotionCalculator();
    Player getPlayer();

    /**
     * @return An optional list of listeners which will be notified on
     * each tick.
     */
    List<Consumer<State>> getListeners();

    record Standard(
            Configuration configuration,
            int desiredTickRate,
            int desiredRefreshRate,
            MotionCalculator motionCalculator,
            Player player,
            List<Consumer<State>> listeners
    ) implements Setup {
        @Override
        public Configuration getConfiguration() {
            return configuration;
        }

        @Override
        public int getDesiredTickRate() {
            return desiredTickRate;
        }

        @Override
        public int getDesiredRefreshRate() {
            return desiredRefreshRate;
        }

        @Override
        public MotionCalculator getMotionCalculator() {
            return motionCalculator;
        }

        @Override
        public Player getPlayer() {
            return player;
        }

        @Override
        public List<Consumer<State>> getListeners() {
            return listeners;
        }
    }
}
