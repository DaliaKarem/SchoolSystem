package Functions;

import model.Teacher;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import services.TeacherServices;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Teacherfunctions {
    Scanner input = new Scanner(System.in);
    List<Teacher> teachers = new ArrayList<>();
    TeacherServices teacherServices = new TeacherServices();

    private void displayTeacherInfo(Row row) {
        System.out.println("Teacher Information:");
        System.out.println("Name: " + row.getCell(1).getStringCellValue());
        System.out.println("Email: " + row.getCell(5).getStringCellValue());
        System.out.println("Address: " + row.getCell(6).getStringCellValue());
        System.out.println("Grade Courses: " + row.getCell(3).getStringCellValue());
        System.out.println("Phone: " + (long) row.getCell(4).getNumericCellValue());
    }
    public void addTeacher() {
        System.out.print("Enter name: ");
        String name = input.nextLine();
        System.out.print("Enter ID: ");
        int id = input.nextInt();
        input.nextLine(); // Consume newline character
        System.out.print("Enter Email: ");
        String email = input.nextLine();
        System.out.print("Enter Address: ");
        String address = input.nextLine();
        System.out.print("Enter Grade->Courses: ");
        String gradeCourses = input.nextLine();
        System.out.print("Enter Age: ");
        double age = input.nextDouble();
        input.nextLine(); // Consume newline character
        System.out.print("Enter Phone: ");
        long phone = input.nextLong();
        input.nextLine(); // Consume newline character
        Teacher newTeacher = new Teacher(id, name, age, gradeCourses, phone, email, address, true);
        teachers.add(newTeacher);
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(newTeacher);
        teacherServices.writeToExcelTeacher("D:\\Projects\\SchoolSystem\\DB\\TeacherDB.xlsx", teacherList);
    }

    public void editTeacherInfo() {
        System.out.print("Enter Name of teacher to display info: ");
        String name = input.nextLine();
        boolean found = false;
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Projects\\SchoolSystem\\DB\\TeacherDB.xlsx"));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                if (row.getCell(1).getStringCellValue().equalsIgnoreCase(name)) {
                    found = true;
                    displayTeacherInfo(row);
                    System.out.print("Which info do you want to Edit (1-Name, 2-Email, 3-Address, 4-GradeCourses, 5-Phone): ");
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
                            columnIndex = 5; // Email column
                            break;
                        case 3:
                            columnIndex = 6; // Address column
                            break;
                        case 4:
                            columnIndex = 3; // GradeCourses column
                            break;
                        case 5:
                            columnIndex = 4; // Phone column
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
                FileOutputStream outFile = new FileOutputStream(new File("D:\\Projects\\SchoolSystem\\DB\\TeacherDB.xlsx"));
                workbook.write(outFile);
                outFile.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void searchTeacher() {
        System.out.print("Enter Name of teacher to display info: ");
        String name = input.nextLine();
        boolean found = false;
        try {
            FileInputStream file = new FileInputStream(new File("D:\\Projects\\SchoolSystem\\DB\\TeacherDB.xlsx"));
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
                System.out.println("Teacher not found.");
            } else {
                FileOutputStream outFile = new FileOutputStream(new File("D:\\Projects\\SchoolSystem\\DB\\TeacherDB.xlsx"));
                workbook.write(outFile);
                System.out.println("Teacher information displayed successfully.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
