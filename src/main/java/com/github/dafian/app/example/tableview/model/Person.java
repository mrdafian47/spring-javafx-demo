package com.github.dafian.app.example.tableview.model;

public class Person {

    private String firstName = null;
    private String lastName = null;

    private String category = null;

    private boolean isXyz = true;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Person(String firstName, String lastName, String category, boolean isXyz) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.category = category;
        this.isXyz = isXyz;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isXyz() {
        return isXyz;
    }

    public void setXyz(boolean xyz) {
        isXyz = xyz;
    }
}
