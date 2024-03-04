package model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    Course course;
    String Grads_Course;
    String Email;
    String Address;
    long phone;
    boolean isAbsent;
    public Teacher() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
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
//    public static List<Teacher> createTeacherData() {
//        List<Teacher> users = new ArrayList<Teacher>();
//        List<String> courseNames1 = new ArrayList<>();
//        courseNames1.add("Course1");
//        courseNames1.add("Course");
//        List<Double> numbers = new ArrayList<>();
//        numbers.add(1.0);
//        numbers.add(2.0);
//        numbers.add(3.0);
//        users.add(new Teacher("Teacher1", 2, new Course(courseNames1),"Teacher1@gmail","125street" ));
//        List<String> courseNames2 = new ArrayList<>();
//        courseNames2.add("Course2");
//        courseNames2.add("Course");
//        users.add(new Teacher("Teacher2", 1, new Course(courseNames1),"Teacher2@gmail","125street" ));
//        List<String> courseNames3 = new ArrayList<>();
//        courseNames3.add("Course3");
//        courseNames3.add("Course");
//        users.add(new Teacher("Teacher3", 2, new Course(courseNames1),"Teacher3@gmail","125street" ));
//        return users;
//    }
}
