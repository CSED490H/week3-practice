package edu.postech.csed332.homework2;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ExpTest {

    @Test
    void testParserOK() {
        String expStr = "((p1 || (p2 && (! p3))) || true)";
        Exp exp = ExpParser.parse(expStr);
        System.out.println(exp.toPrettyString());
        assertEquals(expStr, exp.toPrettyString());
    }

    @Test
    void testParserError() {
        assertThrows(IllegalStateException.class, () -> {
            Exp exp = ExpParser.parse("p1 || p2 && ! p0 || true");
        });
    }

    /*
     * TODO: add  test methods to achieve at least 80% branch coverage of the classes:
     *  Conjunction, Constant, Disjunction, Negation, Variable.
     * Each test method should have appropriate JUnit assertions to test a single behavior.
     * You should not add arbitrary code to test methods to just increase coverage.
     */

    @Test
    void testEvaluateConstant() {
        String expStr = "true";
        Exp exp = ExpParser.parse(expStr);
        assertEquals(true, exp.evaluate(Collections.emptyMap()));
    }

    @Test
    void testEvaluateNegation() {
        String expStr = "! true";
        Exp exp = ExpParser.parse(expStr);
        assertEquals(false, exp.evaluate(Collections.emptyMap()));
    }

    @Test
    void testEvaluateVariable() {
        String expStr = "p1";
        Exp exp = ExpParser.parse(expStr);
        Map<Integer, Boolean> assignments = new HashMap<>();
        assignments.put(1, true);
        assertEquals(true, exp.evaluate(assignments));
    }

    @Test
    void testEvaluateConjunction() {
        String expStr = "p1 && false";
        Exp exp = ExpParser.parse(expStr);
        Map<Integer, Boolean> assignments = new HashMap<>();
        assignments.put(1, true);
        assertEquals(false, exp.evaluate(assignments));
    }
}
