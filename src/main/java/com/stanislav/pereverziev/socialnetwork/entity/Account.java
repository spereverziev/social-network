package com.stanislav.pereverziev.socialnetwork.entity;

import com.stanislav.pereverziev.socialnetwork.entity.friendRequest.FriendsRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
@Entity
@Table(name="accounts")
@NamedQueries({
        @NamedQuery(name = "findByUser",query = "from Account account where account.user = :user"),
        @NamedQuery(name = "findByName",
                query = "from Account account where concat(account.firstName,account.lastName) like :name")
})
public class Account implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    private int age;
    private String email;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
    private List<FriendsRequest> friendsRequests;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "friends",
            joinColumns = { @JoinColumn(name = "account_id")},
            inverseJoinColumns = {@JoinColumn(name = "friend_id")})
    private List<User> friends;

    @OneToMany(mappedBy = "account")
    private List<Message> messages;

    public Account() {
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<User> getFriends() {
        return friends;
    }

    public List<FriendsRequest> getFriendsRequests() {
        return friendsRequests;
    }

    public void setFriendsRequests(List<FriendsRequest> friendsRequests) {
        this.friendsRequests = friendsRequests;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
