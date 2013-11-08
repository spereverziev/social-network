package com.stanislav.pereverziev.socialnetwork.entity;

import java.io.Serializable;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */
public class Message implements Serializable{
    private int id;
    private int fromUser;
    private int toUser;
    private String text;
    private Boolean isRead;

    public Message(int id, int fromUser, int toUser, String text, Boolean isRead) {
        this.id = id;
        this.fromUser = fromUser;
        this.toUser = toUser;
        this.text = text;
        this.isRead = isRead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFromUser() {
        return fromUser;
    }

    public void setFromUser(int fromUser) {
        this.fromUser = fromUser;
    }

    public int getToUser() {
        return toUser;
    }

    public void setToUser(int toUser) {
        this.toUser = toUser;
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
