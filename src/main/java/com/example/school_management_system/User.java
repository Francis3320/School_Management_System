package com.example.school_management_system;

public class User {
    private String Name;
    private int Age;

    public User(String name, int age) {
        Name = name;
        Age = age;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }
}
