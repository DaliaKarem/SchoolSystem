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
    Scanner input=new Scanner(System.in);
        public void writeToExcelTeacher(String path,List<Teacher> users)
        {
            String[] row_heading = {"ID","Name","Age","Grade->Course","Phone","Email","Address","Absent"};
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
}
