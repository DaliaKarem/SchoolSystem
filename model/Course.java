package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private List<String> names;
    // Default constructor
    public Course() {
        this.names = new ArrayList<>();

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

}