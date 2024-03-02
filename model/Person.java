package model;

public class Person {
    String Name;
    int id;
    int age;
    boolean isAbsent;
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public boolean isAbsent() {
        return isAbsent;
    }
    public void setAbsent(boolean isAbsent) {
        this.isAbsent = isAbsent;
    };
    
}
