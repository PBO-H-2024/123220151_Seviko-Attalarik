package main;

import bangunRuang.Cylinder;
import bangunRuang.TriangularPyramid;

import java.util.Scanner;

public class Main {
    public static void pauseScr(){
        System.out.print("Press Enter twice to continue");
        try{
            System.in.read();
        }
        catch(Exception e){
            System.out.println("Input failed");
        }
    }

    public static void main(String[] args) {
        boolean exit = false;
        Scanner scanner = new Scanner(System.in); // Move scanner outside the loop
        while (!exit) {
            System.out.print("Choose a shape:\n" +
                    "1. Triangular pyramid\n" +
                    "2. Cylinder\n" +
                    "3. Exit\n" +
                    ">> ");
            char shape = scanner.next().charAt(0);
            // scanner.close(); // Don't close scanner here
            switch (shape) {
                case '1':
                    System.out.println("Triangular pyramid selected");
                    opt1(scanner);
                    pauseScr();
                    break;
                case '2':
                    System.out.println("Cylinder selected");
                    opt2(scanner);
                    pauseScr();
                    break;
                case '3':
                    System.out.println("Good bye!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        scanner.close(); // Close scanner outside the loop
    }

    static void opt1(Scanner scanner) {
        double base, sideA, sideB, HTP;
        System.out.println("Input:");
        System.out.print("Base\t\t\t\t: ");
        base = scanner.nextDouble();
        System.out.print("Side A\t\t\t\t: ");
        sideA = scanner.nextDouble();
        System.out.print("Side B\t\t\t\t: ");
        sideB = scanner.nextDouble();
        System.out.print("Height of\nTriangular Pyramid\t: ");
        HTP = scanner.nextDouble();

        TriangularPyramid TP = new TriangularPyramid(base, sideA, sideB, HTP);
        System.out.println("\n=========================\n" +
                           "\nOutput:\n" +
                           "Triangle:\n" +
                           "Area\t\t: "  + TP.area() + "\n" +
                           "Perimeter\t: " + TP.perimeter() + "\n");

        System.out.println("Triangular Pyramid:\n" +
                           "Volume\t\t: " + TP.volume() + "\n" +
                           "Area\t\t: " + TP.TPArea() + "\n");
    }

    static void opt2(Scanner scanner) {
        double radius, height;
        System.out.println("Input:");
        System.out.print("Radius\t\t\t\t: ");
        radius = scanner.nextDouble();
        System.out.print("Height of Cylinder\t: ");
        height = scanner.nextDouble();

        Cylinder CylinderObj = new Cylinder(radius, height);
        System.out.println("\n=========================\n" +
                "\nOutput:\n" +
                "Circle:\n" +
                "Area\t\t\t: "  + CylinderObj.area() + "\n" +
                "Circumference\t: " + CylinderObj.circumference() + "\n");

        System.out.println("Triangular Pyramid:\n" +
                "Volume\t\t\t: " + CylinderObj.volume() + "\n" +
                "Area\t\t\t: " + CylinderObj.cArea() + "\n");
    }
}
