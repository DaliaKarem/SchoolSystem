package model;

import java.util.ArrayList;
import java.util.List;
public class Student extends Person {
    int Grade;
    String Estimation;
    Course course;

     public Student() {
    }
//String name, int id, String Email_Parents, String address, int grade, List<String> courses, double age, long phone, boolean isAbsent
    public Student(int Id,String name,int Grade, String Estimation,String Email,String address, Course course,double age,long phone,boolean isAbsent) {
        this.Name = name;
        this.Estimation = Estimation;
        this.course = course;
        this.Grade = Grade;
        this.id=Id;
        this.Email=Email;
        this.Address=address;
        this.age=age;
        this.phone=phone;
        this.isAbsent=isAbsent;
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

    public void setGrade(int grade) {
        this.Grade = grade;
    }

    public String getEstimation() {
        return Estimation;
    }

    public void setEstimation(String estimation) {
        Estimation = estimation;
    }
}