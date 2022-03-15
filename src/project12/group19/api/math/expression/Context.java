package project12.group19.api.math.expression;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public interface Context {
    Map<String, Expression> getVariables();

    default Context with(String name, Expression value) {
        Map<String, Expression> variables = new HashMap<>(getVariables());
        variables.put(name, value);
        return new Standard(variables);
    }

    default Context with(String name, double value) {
        return with(name, new Expression.Constant(value));
    }

    static Context empty() {
        return new Standard(Collections.emptyMap());
    }

    static Context create(String k1, Expression v1) {
        return new Standard(Map.of(k1, v1));
    }

    static Context create(String k1, Expression v1, String k2, Expression v2) {
        return new Standard(Map.of(k1, v1, k2, v2));
    }

    static Context create(String k1, double v1) {
        return new Standard(Map.of(k1, new Expression.Constant(v1)));
    }

    static Context create(String k1, double v1, String k2, double v2) {
        return new Standard(Map.of(k1, new Expression.Constant(v1), k2, new Expression.Constant(v2)));
    }

    record Standard(Map<String, Expression> variables) implements Context {
        @Override
        public Map<String, Expression> getVariables() {
            return variables;
        }
    }
}
