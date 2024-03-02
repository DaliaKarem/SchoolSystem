package model;

import java.util.ArrayList;
import java.util.List;
public class Student extends Person {
    double Grade;
    char Estimation;
    Course course;

     public Student() {
    }

    public Student(String name,double Grade, char Estimation, Course course) {
        this.Name = name;
        this.Estimation = Estimation;
        this.course = course;
        this.Grade = Grade;
    }
    public List<String> getCourseNames() {
        if (course != null) {
            return course.getNames();
        } else {
            return null;
        }
    }
    public void setCourseNames(List<String> courses) {
        if (course != null) {
            course.setNames(courses);
        }
    }

    public double getGrade() {
        return Grade;
    }

    public void setGrade(double grade) {
        Grade = grade;
    }

    public char getEstimation() {
        return Estimation;
    }

    public void setEstimation(char estimation) {
        Estimation = estimation;
    }

    public static List<Student> createUserData() {
        List<Student> users = new ArrayList<Student>();
        List<String> courseNames1 = new ArrayList<>();
        courseNames1.add("Course1");
        courseNames1.add("Course");
        users.add(new Student("user1 ", 2, 'B', new Course(courseNames1)));
        List<String> courseNames2 = new ArrayList<>();
        courseNames2.add("Course2");
        courseNames2.add("Course");
        users.add(new Student("user11", 3, 'A', new Course(courseNames2)));
        List<String> courseNames3 = new ArrayList<>();
        courseNames3.add("Course3");
        courseNames3.add("Course");
        users.add(new Student("user111", 4, 'B', new Course(courseNames3)));
        List<String> courseNames4 = new ArrayList<>();
        courseNames4.add("Course4");
        courseNames4.add("Course");
        users.add(new Student("user1111", 5, 'A', new Course(courseNames4)));
        List<String> courseNames5 = new ArrayList<>();
        courseNames5.add("Course5");
        courseNames5.add("Course");
        users.add(new Student("user11111", 6, 'B', new Course(courseNames5)));
        return users;
    }
}