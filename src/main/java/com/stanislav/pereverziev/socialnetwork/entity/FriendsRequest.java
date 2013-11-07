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
    @Column(name = "from_user")
    private int fromUser;
    @Column(name = "to_user")
    private int toUser;
    @Column(name = "is_accepted")
    private boolean isAccepted;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

}
