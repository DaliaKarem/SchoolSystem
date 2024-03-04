package services;

import Functions.Teacherfunctions;
import model.Person;
import model.Student;
import model.Teacher;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeacherServices extends  Services{

        Teacher Teacher=new Teacher();

        public void writeToExcelTeacher(String path,List<Teacher> users)
        {
            String[] row_heading = {"ID","Name","Age","Grade->Course","Phone","Email","Address","Absent"};
            //List<Teacher> users =createTeacherData();
            writeToExcelSheet(row_heading, users, "Teacher Details ", path);
        }

    public List<Teacher> readFromExcelTeacher(String path) {
        List<Person> allPersons = readDataFromExcel(path);
        List<Teacher> Teachers = new ArrayList<>();

        for (Person person : allPersons) {
            if (person instanceof Teacher) {
                Teachers.add((Teacher) person);
            }
        }

        return Teachers;
    }

    Teacherfunctions teacherfunctions=new Teacherfunctions();
    Scanner input=new Scanner(System.in);
    public void editTeacherInfo(String path, String nameToUpdate) {
        boolean found = false;
        try {
            FileInputStream file = new FileInputStream(new File(path));
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheetAt(0);

            for (Row row : sheet) {
                if (row.getCell(1).getStringCellValue().equalsIgnoreCase(nameToUpdate)) {
                    found = true;
                    teacherfunctions.displayTeacherInfo(String.valueOf(row));
                    System.out.print("Which info do you want to Edit (1-Name, 2-Email, 3-Address, 4-GradeCourses, 5-Phone): ");
                    int choice = input.nextInt();
                    input.nextLine();
                    System.out.print("Enter Update: ");
                    String updateString = input.nextLine();
                    Cell cellToUpdate = row.getCell(choice); // Assuming the column indices match the choices
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
                FileOutputStream outFile = new FileOutputStream(new File(path));
                workbook.write(outFile);
                outFile.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
