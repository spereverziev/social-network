package com.stanislav.pereverziev.socialnetwork.entity;

import java.io.Serializable;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public class User implements Serializable {
    private int id;
    private String login;
    private String password;

    public User() {
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
