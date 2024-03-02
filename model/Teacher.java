package model;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    Course course;
    List<Double>Grads;
    String Email;
    String Address;

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

    public Teacher(String name, List<Double> Grade, Course course, String Email, String Address) {
        this.Name = name;
        this.Address = Address;
        this.course = course;
        this.Grads = Grade;
        this.Email=Email;

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
    public List<Double> getGrads() {
        return Grads;
    }
    public void setGrads(List<Double> grads) {
        Grads = grads;
    }

    public static List<Teacher> createTeacherData() {
        List<Teacher> users = new ArrayList<Teacher>();
        List<String> courseNames1 = new ArrayList<>();
        courseNames1.add("Course1");
        courseNames1.add("Course");
        List<Double> numbers = new ArrayList<>();
        numbers.add(1.0);
        numbers.add(2.0);
        numbers.add(3.0);
        users.add(new Teacher("Teacher1", numbers, new Course(courseNames1),"Teacher1@gmail","125street" ));
        List<String> courseNames2 = new ArrayList<>();
        courseNames2.add("Course2");
        courseNames2.add("Course");
        users.add(new Teacher("Teacher2", numbers, new Course(courseNames1),"Teacher2@gmail","125street" ));
        List<String> courseNames3 = new ArrayList<>();
        courseNames3.add("Course3");
        courseNames3.add("Course");
        users.add(new Teacher("Teacher3", numbers, new Course(courseNames1),"Teacher3@gmail","125street" ));
        return users;
    }
}
