import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ExpressionCalculatorTest {
    ExpressionCalculator calculator = new ExpressionCalculator();

    @Test
    void evaluate_integer() {
        // Given
        long num = 123;
        long zero = 0;

        long ans = calculator.evaluate("123");
        assertEquals(ans, num);

        ans = calculator.evaluate("0");
        assertEquals(ans, zero);

        ans = calculator.evaluate("");
        assertEquals(ans, zero);
    }

    @Test
    void evaluate_add() {
        // Given
        long ans;
        long two = 2;
        long seven = 7;
        long twelve = 12;

        ans = calculator.evaluate("add 1 1");
        assertEquals(ans, 2);

        ans = calculator.evaluate("multiply 2 4");
        assertEquals(ans, 8);

        ans = calculator.evaluate("(add 1 1)");
        assertEquals(ans, two);

        ans = calculator.evaluate("(add 0 (add 3 4))");
        assertEquals(ans, seven);

        ans = calculator.evaluate("(add 3 (add (add 3 3) 3))");
        assertEquals(ans, twelve);
    }

    @Test
    void evaluate_multiply() {
        // Given
        long ans;
        long one = 1;
        long zero = 0;
        long twentyFour = 24;
        long eightyOne = 81;

        ans = calculator.evaluate("(multiply 1 1)");
        assertEquals(ans, one);

        ans = calculator.evaluate("(multiply 0 (multiply 3 4))");
        assertEquals(ans, zero);

        ans = calculator.evaluate("(multiply 2 (multiply 3 4))");
        assertEquals(ans, twentyFour);

        ans = calculator.evaluate("(multiply 3 (multiply (multiply 3 3) 3))");
        assertEquals(ans, eightyOne);

    }

    @Test
    void evaluate_combined() {
        // Given
        long ans;
        long seven = 7;
        long twentyEight = 28;
        long forty = 40;

        ans = calculator.evaluate("(add 1 (multiply 2 3))");
        assertEquals(ans, seven);

        ans = calculator.evaluate("(multiply 2 (add (multiply 2 3) 8))");
        assertEquals(ans, twentyEight);

        ans = calculator.evaluate("(add 1 2 3 4 (multiply 2 3 5))");
        assertEquals(ans, forty);
    }

    @Test
    void evaluate_exponent() {
        // Given
        long ans;
        long exponent = 32;

        ans = calculator.evaluate("(exponent 2 5)");
        assertEquals(ans, exponent);
    }

}