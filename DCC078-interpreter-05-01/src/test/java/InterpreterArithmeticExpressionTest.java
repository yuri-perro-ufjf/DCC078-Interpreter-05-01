import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InterpreterArithmeticExpressionTest {
    @Test
    void shouldBeCalcSumExpression() {
        InterpreterExpression interpreter = new InterpreterArithmeticExpression("15 + 150");
        assertEquals(165.0, interpreter.interpret());
    }

    @Test
    void shouldBeCalcSubExpression() {
        InterpreterExpression interpreter = new InterpreterArithmeticExpression("100 - 80");
        assertEquals(20.0, interpreter.interpret());
    }

    @Test
    void shouldBeCalcMultiplyExpression() {
        InterpreterExpression interpreter = new InterpreterArithmeticExpression("15 * 10");
        assertEquals(150.0, interpreter.interpret());
    }

    @Test
    void shouldBeCalcDivisionExpression() {
        InterpreterExpression interpreter = new InterpreterArithmeticExpression("15 / 3");
        assertEquals(5.0, interpreter.interpret());
    }

    @Test
    void shouldBeCalCombinedExpression() {
        InterpreterExpression interpreter = new InterpreterArithmeticExpression("100 / 2 * 3 + 100 - 10");
        assertEquals(240.0, interpreter.interpret());
    }

    @Test
    void shouldBeReturnExceptionInvalidElement() {
        try {
            InterpreterExpression interpreter = new InterpreterArithmeticExpression("2 ^ 2");
            assertEquals(4.0, interpreter.interpret());
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Invalid Expression with element", e.getMessage());
        }
    }

    @Test
    void shouldBeReturnInvalidException() {
        try {
            InterpreterExpression interpreter = new InterpreterArithmeticExpression("2 +");
            assertEquals(4.0, interpreter.interpret());
            fail();
        } catch(IllegalArgumentException e) {
            assertEquals("Invalid Expression", e.getMessage());
        }
    }
}