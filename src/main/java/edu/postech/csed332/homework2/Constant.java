package edu.postech.csed332.homework2;

import java.util.Map;
import java.util.Set;

/**
 * A Boolean constant, either true or false.
 */
public record Constant(boolean value) implements Exp {
    @Override
    public Boolean evaluate(Map<Integer, Boolean> assignment) {
        return this.value;
    }

    @Override
    public String toPrettyString() {
        return Boolean.toString(value());
    }
}