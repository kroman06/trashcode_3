package org.kroman;

public class Calculator {
    public double add(double a, double b) {
        return a + b;
    }
    public double subtract(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    /**
     * @throws ArithmeticException if b is equals to 0
     */
    public double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Can't divide by zero!");
        }
        return a / b;
    }

    public double sqrt(double a) throws InvalidInputException {
        if (a < 0) {
            throw new InvalidInputException("You can't take sqrt from a negative number!");
        }
        return Math.sqrt(a);
    }

    public double pow(double base, double exp) throws InvalidInputException, ArithmeticException {
        if (base < 0 && exp % 1 != 0) {
            throw new InvalidInputException("Power you're trying to get is a root from negative number, that's not allowed!");
        } else if (base == 0 && exp < 0) {
            // 1 / 0^exp
            throw new ArithmeticException("Power you're trying to get will result zero division, that's not allowed!");
        }
        return Math.pow(base, exp);
    }
}