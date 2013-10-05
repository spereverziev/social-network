package com.stanislav.pereverziev.socialnetwork.entity;

import java.io.Serializable;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */
public class Message implements Serializable{
    private int id;
    private int from_user;
    private int to_user;
    private String text;
    private Boolean isRead;

    public Message(int id, int from_user, int to_user, String text, Boolean isRead) {
        this.id = id;
        this.from_user = from_user;
        this.to_user = to_user;
        this.text = text;
        this.isRead = isRead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrom_user() {
        return from_user;
    }

    public void setFrom_user(int from_user) {
        this.from_user = from_user;
    }

    public int getTo_user() {
        return to_user;
    }

    public void setTo_user(int to_user) {
        this.to_user = to_user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }
}
