import org.kroman.Calculator;
import org.kroman.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalcTest {
    private Calculator calculator;
    private static final double DELTA = 0.0001;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testAddPositiveNumbers() {
        assertEquals(5.0, calculator.add(2.0, 3.0), DELTA);
    }

    @Test
    void testAddWithNegative() {
        assertEquals(-1.0, calculator.add(2.0, -3.0), DELTA);
    }

    @Test
    void testSubtract() {
        assertEquals(2.0, calculator.subtract(5.0, 3.0), DELTA);
    }

    @Test
    void testSubtractToNegative() {
        assertEquals(-2.0, calculator.subtract(3.0, 5.0), DELTA);
    }

    @Test
    void testMultiply() {
        assertEquals(21.0, calculator.multiply(3.0, 7.0), DELTA);
    }

    @Test
    void testMultiplyTwoNegatives() {
        assertEquals(25.0, calculator.multiply(-5.0, -5.0), DELTA);
    }

    @Test
    void testDivide() {
        assertEquals(5.0, calculator.divide(10.0, 2.0), DELTA);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(10.0, 0.0));
    }

    @Test
    void testDivideZeroByNumber() {
        assertEquals(0.0, calculator.divide(0.0, 5.0), DELTA);
    }

    @Test
    void testSqrtPositive() throws InvalidInputException {
        assertEquals(3.0, calculator.sqrt(9.0), DELTA);
    }

    @Test
    void testPow() throws InvalidInputException {
        assertEquals(16.0, calculator.pow(4, 2), DELTA);
    }

    @Test
    void testPowSqrt() {
        assertThrows(InvalidInputException.class, () -> calculator.pow(-4, 0.5));
    }

    @Test
    void testPowZeroDivision() {
        assertThrows(ArithmeticException.class, () -> calculator.pow(0, -2));
    }

    @Test
    void testSqrtZero() throws InvalidInputException {
        assertEquals(0.0, calculator.sqrt(0.0), DELTA);
    }

    @Test
    void testSqrtNegative() {
        Exception exception = assertThrows(InvalidInputException.class, () -> calculator.sqrt(-25.0));
        assertTrue(exception.getMessage().contains("You can't take sqrt from a negative number!"));
    }
}