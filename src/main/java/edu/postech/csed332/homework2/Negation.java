package edu.postech.csed332.homework2;

import java.util.Map;
import java.util.Set;

/**
 * A Boolean expression whose top-level operator is ! (not).
 */
public record Negation(Exp subExp) implements Exp {
    @Override
    public Boolean evaluate(Map<Integer, Boolean> assignment) {
        return ! this.subExp.evaluate(assignment);
    }

    @Override
    public String toPrettyString() {
        return "(! " + subExp().toPrettyString() + ")";
    }
}
