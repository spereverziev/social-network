package com.stanislav.pereverziev.socialnetwork.entity;

import java.io.Serializable;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public class Account implements Serializable {
    private int id;
    private int account_id;
    private String login;
    private String password;

    public Account(int id, int account_id, String login, String password) {
        this.id = id;
        this.account_id = account_id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccount_id() {
        return account_id;
    }

    public void setAccount_id(int account_id) {
        this.account_id = account_id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (account_id != account.account_id) return false;
        if (id != account.id) return false;
        if (login != null ? !login.equals(account.login) : account.login != null) return false;
        if (password != null ? !password.equals(account.password) : account.password != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + account_id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }
}
