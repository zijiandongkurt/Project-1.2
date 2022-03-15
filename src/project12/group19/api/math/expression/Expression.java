package project12.group19.api.math.expression;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public interface Expression {
    /**
     * Tells whether provided context satisfies all unset variables.
     */
    boolean isComputable(Context context);
    double compute(Context context);

    record Constant(double value) implements Expression {
        @Override
        public boolean isComputable(Context context) {
            return true;
        }

        @Override
        public double compute(Context context) {
            return value;
        }
    }

    record Variable(String name) implements Expression {
        @Override
        public boolean isComputable(Context context) {
            return Optional.ofNullable(context.getVariables().get(name))
                    .map(replacement -> replacement.isComputable(context))
                    .orElse(false);
        }

        @Override
        public double compute(Context context) {
            return context.getVariables().get(name).compute(context);
        }
    }

    record Subtraction(Expression minuend, Expression subtrahend) implements Expression {
        @Override
        public boolean isComputable(Context context) {
            return minuend.isComputable(context) && subtrahend.isComputable(context);
        }

        @Override
        public double compute(Context context) {
            return minuend.compute(context) - subtrahend.compute(context);
        }
    }

    record Sum(List<Expression> components) implements Expression {
        public Sum(Expression... components) {
            this(Arrays.asList(components));
        }

        public Sum(Expression left, Expression right) {
            this(Arrays.asList(left, right));
        }

        @Override
        public boolean isComputable(Context context) {
            return components.stream().allMatch(component -> component.isComputable(context));
        }

        @Override
        public double compute(Context context) {
            return components.stream().mapToDouble(component -> component.compute(context)).sum();
        }
    }

    record Multiplication(List<Expression> components) implements Expression {
        public Multiplication(Expression... components) {
            this(Arrays.asList(components));
        }

        public Multiplication(Expression left, Expression right) {
            this(Arrays.asList(left, right));
        }

        @Override
        public boolean isComputable(Context context) {
            return components.stream().allMatch(component -> component.isComputable(context));
        }

        @Override
        public double compute(Context context) {
            return components.stream().mapToDouble(component -> component.compute(context)).reduce(1, (left, right) -> left * right);
        }
    }

    record Division(Expression dividend, Expression divisor) implements Expression {
        @Override
        public boolean isComputable(Context context) {
            return dividend.isComputable(context) && divisor.isComputable(context);
        }

        @Override
        public double compute(Context context) {
            return dividend.compute(context) / divisor.compute(context);
        }
    }

    record Sine(Expression argument) implements Expression {
        @Override
        public boolean isComputable(Context context) {
            return argument.isComputable(context);
        }

        @Override
        public double compute(Context context) {
            return Math.sin(argument.compute(context));
        }
    }

    record Cosine(Expression argument) implements Expression {
        @Override
        public boolean isComputable(Context context) {
            return argument.isComputable(context);
        }

        @Override
        public double compute(Context context) {
            return Math.cos(argument.compute(context));
        }
    }

    record Absolute(Expression argument) implements Expression {
        @Override
        public boolean isComputable(Context context) {
            return argument.isComputable(context);
        }

        @Override
        public double compute(Context context) {
            return Math.abs(argument.compute(context));
        }
    }

    record Exponent(Expression base, Expression power) implements Expression {
        @Override
        public boolean isComputable(Context context) {
            return base.isComputable(context) && power.isComputable(context);
        }

        @Override
        public double compute(Context context) {
            return Math.pow(base.compute(context), power.compute(context));
        }
    }

    record Logarithm(Expression base, Expression value) implements Expression {
        @Override
        public boolean isComputable(Context context) {
            return base.isComputable(context) && value.isComputable(context);
        }

        @Override
        public double compute(Context context) {
            // just changing the base, nothing to see here
            return Math.log(value.compute(context)) / Math.log(base.compute(context));
        }
    }
}
