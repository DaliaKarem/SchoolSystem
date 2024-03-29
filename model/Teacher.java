package model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    Course course;
    String Grads_Course;
    public Teacher() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    //ID,name,Age, grade_Course, Phone, email, address,Absent
public Teacher(int ID, String name, double age, String Grade_Course, long phone, String Email, String address,boolean isAbsent) {
    this.Grads_Course = Grade_Course;
    this.Address = address; // Assigning to this.address
    this.phone = phone;
    this.Email = Email;
    this.Name=name;
    this.id=ID;
    this.age=age;
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
    public String getGrads_Course() {
        return Grads_Course;
    }
    public void setGrads_Course(String grads_Course) {
        Grads_Course = grads_Course;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }
}
