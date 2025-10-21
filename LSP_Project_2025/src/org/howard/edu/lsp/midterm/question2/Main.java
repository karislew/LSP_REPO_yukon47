package org.howard.edu.lsp.midterm.question2;

public class Main {
    public static void main(String[] args) {
        // Correct area calculations
        System.out.println("Circle radius 3.0 → area = " + AreaCalculator.area(3.0));
        System.out.println("Rectangle 5.0 x 2.0 → area = " + AreaCalculator.area(5.0, 2.0));
        System.out.println("Triangle base 10, height 6 → area = " + AreaCalculator.area(10, 6));
        System.out.println("Square side 4 → area = " + AreaCalculator.area(4));

        // Example of exception handling
        try {
            System.out.println("Attempting invalid circle area:");
            System.out.println(AreaCalculator.area(-5.0));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /*
     * Brief Explanation:
     * Method overloading allows a class to have multiple methods with the same name 
     * but different parameters.
     * This improves readability of the program and organization compared to having 
     * separate methods like CircleArea(), RectangleArea(), etc, 
     * since they all perform the same action.
     */
}