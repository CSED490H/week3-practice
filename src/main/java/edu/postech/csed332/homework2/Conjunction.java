package edu.postech.csed332.homework2;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * A Boolean expression whose top-level operator is && (and).
 */
public record Conjunction(Exp... subExps) implements Exp {
    @Override
    public Boolean evaluate(Map<Integer, Boolean> assignment) {
        return this.subExps[0].evaluate(assignment) && this.subExps[1].evaluate(assignment);
    }

    @Override
    public String toPrettyString() {
        return "(" + Arrays.stream(subExps()).map(Exp::toPrettyString)
                .collect(Collectors.joining(" && ")) + ")";
    }
}