package com.course.product.model;

public class Course {
    private String name;
    private int id;
    private String teacher;
    private String description ;

    public Course() {
    }

    public Course(String name, int id, String teacher, String description) {
        this.name = name;
        this.id = id;
        this.teacher = teacher;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getTeacher() {
        return teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", teacher='" + teacher + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

