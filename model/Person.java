package model;

public class Person {
    String Name;
    int id;
    double age;
    boolean isAbsent;
    Person()
    {

    }
    Person(String name,int id,double age,boolean isAbsent)
    {
        this.age=age;
        this.id=id;
        this.isAbsent=isAbsent;
        this.Name=name;
    }
    public String getName() {
        System.out.println("NNNNNNNName  "+Name );
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
    public double getAge() {
        return age;
    }
    public void setAge(double age) {
        this.age = age;
    }
    public boolean isAbsent() {
        return isAbsent;
    }
    public void setAbsent(boolean isAbsent) {
        this.isAbsent = isAbsent;
    };
    
}
