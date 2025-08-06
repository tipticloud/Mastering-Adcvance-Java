package Versioning;

import java.io.Serializable;

public class Employee implements Serializable {


    private static final long serialVersionUID = 1L;

    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;

    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
