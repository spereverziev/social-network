package com.stanislav.pereverziev.socialnetwork.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */

@Entity
@Table(name = "messages")
public class Message implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn(name = "from_user")
    private User sender;
    @OneToOne
    @JoinColumn(name = "to_user")
    private User receiver;
    private String text;
    private Boolean isRead;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public Message() {
    }

    public Message(User sender, User receiver, String text, Boolean read, Account account, Date date) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        isRead = read;
        this.account = account;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
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

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
