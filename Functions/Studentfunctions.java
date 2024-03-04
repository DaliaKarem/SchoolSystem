package Functions;

import model.Teacher;
import services.TeacherServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Studentfunctions {
    Scanner input=new Scanner(System.in);
    List<Teacher> teachers = new ArrayList<>();
    TeacherServices teacherServices = new TeacherServices();

    void addStudent(String name,int id,String email,String address,String GradeCourses,double age,long phone)
    {
//        System.out.print("Enter name:");
//        name = input.nextLine();
//        System.out.print("Enter ID:");
//        id = input.nextInt();
//        input.nextLine(); // Consume newline character
//        System.out.print("Enter Email:");
//        email = input.nextLine();
//        System.out.print("Enter Address:");
//        address = input.nextLine();
//        System.out.print("Enter Grade->Courses:");
//        GradeCourses = input.nextLine();
//        System.out.print("Enter Age:");
//        age = input.nextDouble();
//        input.nextLine(); // Consume newline character
//        System.out.print("Enter Phone:");
//        phone = input.nextLong();
//        input.nextLine(); // Consume newline character
//        teachers.add(new Teacher(id, name, age, GradeCourses, phone, email, address, true));
//        teacherServices.writeToExcelTeacher("D:\\Projects\\SchoolSystem\\DB\\TeacherDB.xlsx", teachers);

    }
    
}
