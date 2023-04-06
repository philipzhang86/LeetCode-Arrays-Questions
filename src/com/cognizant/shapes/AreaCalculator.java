package com.cognizant.shapes;

import java.util.Scanner;

public class AreaCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double length = readDoubleInput("Please enter the length of the rectangle:",
                "Invalid input. Please enter a valid number for the length:", scanner);
        double breadth = readDoubleInput("Please enter the breadth of the rectangle:",
                "Invalid input. Please enter a valid number for the breadth:", scanner);
        Rectangle rectangle = new Rectangle();
        rectangle.calculateArea(length, breadth);
    }

    public static double readDoubleInput(String promptMessage, String errorMessage, Scanner scanner) {
        System.out.print(promptMessage);
        while (!scanner.hasNextDouble()) {
            System.out.println(errorMessage);
            scanner.next();
        }
        double value = scanner.nextDouble();
        scanner.nextLine();
        return value;
    }
}
