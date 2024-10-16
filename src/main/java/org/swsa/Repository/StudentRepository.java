package org.swsa.Repository;
import org.swsa.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository
{

    private static Connection connection = null;

    private void initConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = new org.swsa.service.ConnectionService().getConnection();
        }
    }

    public List<Student> retrieveStudents() throws SQLException {
        this.initConnection();
        List<Student> students = new ArrayList<>();
        try {
            this.initConnection();
            // Your database operations here...
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student");

            // Iterate over the result set
            while (resultSet.next()) {
                int studentId = resultSet.getInt("studentId");
                String studentName = resultSet.getString("studentName ");
                String studentAddress = resultSet.getString("studentAddress");

                Student student = new Student(studentId, studentName,studentAddress);
                students.add(student);
            }
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
        } finally {
            // Close the connection when done
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.err.println("Error closing connection: " + e.getMessage());
                }
            }
        }
        return students;
    }

    public boolean insertStudent(Student student) throws SQLException {
        this.initConnection();
        String query = "INSERT INTO student VALUES (?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getStudentName());
            preparedStatement.setString(3, student.getStudentAddress());
                      System.out.println("inserting student data to table: " + student);

            int rowsInserted = preparedStatement.executeUpdate();

            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



}