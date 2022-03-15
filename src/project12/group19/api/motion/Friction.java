package project12.group19.api.motion;

/**
 * A container for details of friction of specific material.
 */
public interface Friction {
    double getStaticCoefficient();
    double getDynamicCoefficient();

    static Friction create(double staticCoefficient, double dynamicCoefficient) {
        return new Standard(staticCoefficient, dynamicCoefficient);
    }

    record Standard(double staticCoefficient, double dynamicCoefficient) implements Friction {
        @Override
        public double getStaticCoefficient() {
            return staticCoefficient;
        }

        @Override
        public double getDynamicCoefficient() {
            return dynamicCoefficient;
        }
    }
}
