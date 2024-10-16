package org.swsa;
import org.swsa.service.ConnectionService;
import org.swsa.service.StudentService;

import java.io.IOException;
import java.util.Scanner;

public class App {

    private static final ConnectionService connectionService = new ConnectionService();

    public static void main(String[] args) throws IOException {
        StudentService studentService = new StudentService();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        do {

            System.out.println("*** Student MANAGEMENT SYSTEM ***");
            System.out.println("_______________________________");
            System.out.println("Select operation:");
            System.out.println("1. Registration form");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Performing CREATE operation on Student");
                    studentService.insertStudent();
                    break;
                case 0:
                    System.out.println("Exiting program");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);
        scanner.close();
    }
}