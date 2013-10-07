package com.stanislav.pereverziev.socialnetwork.entity;

import java.io.Serializable;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public class Account implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private int userId;
    public Account() {
    }

    public Account(int id, String firstName, String lastName, int age, String email,int userId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
