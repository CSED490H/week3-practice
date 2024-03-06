package edu.postech.csed332.homework2;

import java.util.Map;

/**
 * A Boolean expression.
 */
public interface Exp {
    /**
     * Evaluates the truth value of this Boolean expression, given
     * a truth assignment. A truth assignment is a map from variable
     * identifiers to Boolean values. For example, suppose that the
     * formula is "(p1 || p2) && (p2 || ! p3)". This method returns
     * true, given {1 |-> true, 2 |-> false, 3 |-> false}.
     *
     * @param assignment a truth assignment
     * @return true or false
     */
    Boolean evaluate(Map<Integer, Boolean> assignment);

    /**
     * Returns a string representation of this expression.
     *
     * @return a string representation
     */
    String toPrettyString();
}