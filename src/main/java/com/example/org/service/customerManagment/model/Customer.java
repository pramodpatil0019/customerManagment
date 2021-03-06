package com.example.org.service.customerManagment.model;

public class Customer {

    public String name;
    public int id;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Customer(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }
}
