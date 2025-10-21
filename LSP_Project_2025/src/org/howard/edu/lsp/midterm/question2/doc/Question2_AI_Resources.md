For question 2, I started with using ChatGPT to help me generate my code based on the criteria. 

my prompt was: 

Write a class AreaCalculator in the package org.howard.edu.lsp.midterm.question2 with the following overloaded methods: This should be uploaded to your repo. // Circle area public static double area(double radius) // Rectangle area public static double area(double width, double height) // Triangle (base & height) area public static double area(int base, int height) // Square (side length) area public static double area(int side) Requirements: Each method should compute and return the correct area. Circle area: π (use class Math.PI) × r² Rectangle area: width × height Triangle area: ½ × base × height Square area: side² For all methods: throw an IllegalArgumentException if any dimension is ≤ 0. 

Response:

package org.howard.edu.lsp.midterm.question2;

public class AreaCalculator {

    // Circle area
    public static double area(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than zero.");
        }
        return Math.PI * radius * radius;
    }

    // Rectangle area
    public static double area(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be greater than zero.");
        }
        return width * height;
    }

    // Triangle area
    public static double area(int base, int height) {
        if (base <= 0 || height <= 0) {
            throw new IllegalArgumentException("Base and height must be greater than zero.");
        }
        return 0.5 * base * height;
    }

    // Square area
    public static double area(int side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Side length must be greater than zero.");
        }
        return side * side;
    }
}
prompt: how do you write a try and catch statement?

response: 

try {
    // Code that might throw an exception
    int result = 10 / 0; // This will throw an ArithmeticException
} catch (ArithmeticException e) {
    // Code to handle the exception
    System.out.println("Error: " + e.getMessage());
}


After this response, I double checked and tested the code to ensure it worked. I used - https://www.geeksforgeeks.org/java/method-overloading-in-java/ to better understand overloading and change the explanation as I saw fit.   


