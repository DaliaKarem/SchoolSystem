package model;

import java.util.List;

public class Course {
    private List<String> names;
    private int grade;

    // Default constructor
    public Course() {
    }

    // Constructor with name and grade
    public Course(List<String> names) {
        this.names = names;
    }

    // Getters and setters
    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}