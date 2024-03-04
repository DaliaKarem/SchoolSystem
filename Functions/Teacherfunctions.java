package Functions;

import model.Teacher;
import services.TeacherServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Teacherfunctions {
    Scanner input = new Scanner(System.in);
    List<Teacher> teachers = new ArrayList<>();
    TeacherServices teacherServices = new TeacherServices();

    public void displayTeacherInfo(String teacherName) {
        boolean found = false;
        for (Teacher teacher : teachers) {
            if (teacher.getName().equalsIgnoreCase(teacherName)) {
                System.out.println("Teacher Information:");
                System.out.println("Name: " + teacher.getName());
                System.out.println("ID: " + teacher.getId());
                System.out.println("Email: " + teacher.getEmail());
                System.out.println("Address: " + teacher.getAddress());
                System.out.println("Grade Courses: " + teacher.getGrads_Course());
                System.out.println("Age: " + teacher.getAge());
                System.out.println("Phone: " + teacher.getPhone());
                System.out.println("Absent: " + teacher.isAbsent());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Teacher not found.");
        }
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
        teachers.add(new Teacher(id, name, age, gradeCourses, phone, email, address, true));
        teacherServices.writeToExcelTeacher("D:\\Projects\\SchoolSystem\\DB\\TeacherDB.xlsx", teachers);
    }

    public void editTeacherInfo() {
        System.out.print("Enter Name of teacher to display info: ");
        String name = input.nextLine();
        teacherServices.editTeacherInfo("D:\\Projects\\SchoolSystem\\DB\\TeacherDB.xlsx",name);
    }
}
