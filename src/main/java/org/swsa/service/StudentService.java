package org.swsa.service;
import org.swsa.Repository.StudentRepository;
import org.swsa.model.Student;

import java.sql.SQLException;
import java.util.Scanner;

public class StudentService {

    private static final StudentRepository studentRepository = new  StudentRepository();
    public void insertStudent() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls enter student id:");
        int studentId = Integer.parseInt(scanner.nextLine());

        System.out.println("Pls enter student name:");
        String studentName = scanner.nextLine();

        System.out.println("Pls enter student Address:");
        String studentAddress = scanner.nextLine();

        Student student= new Student(studentId, studentName, studentAddress);

        try {
            if (studentRepository.insertStudent(student)) {
                System.out.println("student inserted successfully!");
            } else {
                System.out.println("Failed to insert employee.");
            }
        } catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
}