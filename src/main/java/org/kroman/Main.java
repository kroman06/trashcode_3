package org.kroman;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Calculator calc = new Calculator();
            System.out.print("Enter first number: ");
            double num1 = scanner.nextDouble();
            double num2 = 0;

            System.out.print("Operation (+, -, *, /, sqrt, pow): ");
            String operation = scanner.next();
            if (!operation.equals("sqrt")) {
                System.out.print("Enter second number: ");
                num2 = scanner.nextDouble();
            }

            double result;
            switch (operation) {
                case "+":
                    result = calc.add(num1, num2);
                    System.out.println(num1 + " + " + num2 + " = " + result);
                    break;
                case "-":
                    result = calc.subtract(num1, num2);
                    System.out.println(num1 + " - " + num2 + " = " + result);
                    break;
                case "*":
                    result = calc.multiply(num1, num2);
                    System.out.println(num1 + " * " + num2 + " = " + result);
                    break;
                case "/":
                    result = calc.divide(num1, num2);
                    System.out.println(num1 + " / " + num2 + " = " + result);
                    break;
                case "pow":
                    result = calc.pow(num1, num2);
                    System.out.println("pow( " + num1 + ", " + num2 + ") = " + result);
                    break;
                case "sqrt":
                    result = calc.sqrt(num1);
                    System.out.println("sqrt(" + num1 + ") = " + result);
                    break;
                default:
                    System.out.println("Invalid operation: " + operation);
                    break;
            }

        } catch (ArithmeticException | InvalidInputException e) {
            System.err.println("Error:" + e.getMessage());
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("\n=== Program finished ===");
        }
    }
}