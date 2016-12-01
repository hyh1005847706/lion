package com.edu.feicui.fragment_add_replace;

/**
 * Created by Administrator on 2016/11/26.
 */
public class User {
    private int id;
    private String name;
    private String password;
    private int age;
    private double salary;
    private String img;

    public User() {
    }

    public User(int id, String name, String password, int age, double salary, String img) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.age = age;
        this.salary = salary;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getImg() {
        return img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setImg(String img) {
        this.img = img;
    }
}
