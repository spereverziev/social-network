package com.stanislav.pereverziev.socialnetwork.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/15/13
 */

@Entity
@Table(name = "friends_requests")
public class FriendsRequest implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    @OneToOne
    @JoinColumn(name = "from_user")
    private User sender;
    @OneToOne
    @JoinColumn(name = "to_user")
    private User receiver;
    @Column(name = "is_accepted")
    private boolean isAccepted;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

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

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
