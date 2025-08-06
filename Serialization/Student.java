package Serialization;

import java.io.Serializable;

public class Student implements Serializable {
    private String Name;
    private int id;
    private transient String pass;

    public Student(String name, int id, String pass) {
        Name = name;
        this.id = id;
        this.pass = pass;
    }

    public String getName() {
        return Name;
    }

    public int getId() {
        return id;
    }

    public String getPass() {
        return pass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", id=" + id +
                ", pass='" + pass + '\'' +
                '}';
    }
}
