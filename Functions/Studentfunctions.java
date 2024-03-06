package Functions;

import model.Course;
import model.Student;
import model.Teacher;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.StudentServices;
import services.TeacherServices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Studentfunctions {
    Scanner input=new Scanner(System.in);
    List<Student> students = new ArrayList<>();
    StudentServices studentServices = new StudentServices();
    private void displayTeacherInfo(Row row) {
        System.out.println("Student Information:");
        System.out.println("Name: " + row.getCell(1).getStringCellValue());
        System.out.println("Grade: " +row.getCell(2).getNumericCellValue());
        System.out.println("Estimation: " + row.getCell(3).getStringCellValue());
        System.out.println("Email: " + row.getCell(4).getStringCellValue());
        System.out.println("Address: " + row.getCell(5).getStringCellValue());
        System.out.println("Courses: " + row.getCell(6).getStringCellValue());
        System.out.println("Phone: " + (long) row.getCell(8).getNumericCellValue());
    }
    public void addStudent() {
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter ID: ");
        int id = input.nextInt();
        input.nextLine(); // Consume newline character
        System.out.print("Enter Email of Parents: ");
        String email_Parents = input.nextLine();
        System.out.print("Enter Address: ");
        String address = input.nextLine();
        System.out.print("Enter Grade: ");
        int grade = input.nextInt();
        System.out.print("Enter Age: ");
        double age = input.nextDouble();
        input.nextLine(); // Consume newline character
        System.out.print("Enter Phone: ");
        long phone = input.nextLong();
        input.nextLine(); // Consume newline character

        // Creating Course
        System.out.println("Enter Courses: ");
        List<String> courses = new ArrayList<>();
        System.out.print("Number of courses: ");
        int numCourses = input.nextInt();
        input.nextLine(); // Consume newline character
        for (int i = 0; i < numCourses; i++) {
            System.out.print("Enter course " + (i + 1) + ": ");
            String courseName = input.nextLine();
            courses.add(courseName);
        }
        Course course = new Course(courses);

        students.add(new Student(id, name, grade, "A", email_Parents, address, course, age, phone, true));
        studentServices.writeToExcelStudent("D:\\Projects\\SchoolSystem\\DB\\StudentDB.xlsx", students);
    }
    public void editStudentInfo() {
        System.out.print("Enter Name of Stdent to display info: ");
        String name = input.nextLine();
        boolean found = false;
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Projects\\SchoolSystem\\DB\\StudentDB.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getCell(1).getStringCellValue().equalsIgnoreCase(name)) {
                    found = true;
                    displayTeacherInfo(row);
                    System.out.print("Which info do you want to Edit (1-Name, 2-Email, 3-Address, 4-Grade, 5-Phone,6-Courses): ");
                    int choice = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter Update: ");
                    String updateString = input.nextLine();

                    // Determine the column index based on the user's choice
                    int columnIndex = -1;
                    switch (choice) {
                        case 1:
                            columnIndex = 1; // Name column
                            break;
                        case 2:
                            columnIndex = 4; // Email column
                            break;
                        case 3:
                            columnIndex = 5; // Address column
                            break;
                        case 4:
                            columnIndex = 2; // GradeCourses column
                            break;
                        case 5:
                            columnIndex = 8; // Phone column
                            break;
                        case 6:
                            columnIndex = 6; // Phone column
                            break;
                        default:
                            System.out.println("Invalid choice.");
                            return;
                    }

                    Cell cellToUpdate = row.getCell(columnIndex);
                    if (cellToUpdate != null) {
                        cellToUpdate.setCellValue(updateString);
                    } else {
                        System.out.println("Invalid choice.");
                        return;
                    }
                    System.out.println("Editing Done.");
                    break;
                }
            }
            file.close();
            if (!found) {
                System.out.println("Teacher not found.");
            } else {
                FileOutputStream outFile = new FileOutputStream(new File("D:\\Projects\\SchoolSystem\\DB\\StudentDB.xlsx"));
                workbook.write(outFile);
                outFile.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchStudent() {
        System.out.print("Enter Name of Student to display info: ");
        String name = input.nextLine();
        boolean found = false;
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Projects\\SchoolSystem\\DB\\StudentDB.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getCell(1).getStringCellValue().equalsIgnoreCase(name)) {
                    found = true;
                    displayTeacherInfo(row);
                    break;
                }
            }
            file.close();
            if (!found) {
                System.out.println("Student not found.");
            } else {
                FileOutputStream outFile = new FileOutputStream(new File("D:\\Projects\\SchoolSystem\\DB\\StudentDB.xlsx"));
                workbook.write(outFile);
                System.out.println("Student information displayed successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
