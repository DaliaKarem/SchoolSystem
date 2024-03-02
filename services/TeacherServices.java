package services;

import model.Person;
import model.Student;
import model.Teacher;

import java.util.ArrayList;
import java.util.List;

import static model.Teacher.createTeacherData;

public class TeacherServices extends  Services{

        Teacher Teacher=new Teacher();

        public void writeToExcelTeacher(String path)
        {
            String[] row_heading = {"Name","Grade","Courses","Email","Address"};
            List<Teacher> users =createTeacherData();
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
