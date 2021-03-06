package com.stanislav.pereverziev.socialnetwork.entity;
import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */

@Entity
@Table(name="users")
@NamedQueries({
        @NamedQuery(name = "findByLogin",query = "from User user where user.email = :email")
})
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String email;
    private String password;

    @OneToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public User() {
    }

    public Account getAccount() {
        return account;
    }

    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String login) {
        this.email = login;
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

        User user = (User) o;

        if (id != user.id) return false;
        if (!email.equals(user.email)) return false;
        if (!password.equals(user.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + email.hashCode();
        result = 31 * result + password.hashCode();
        return result;
    }
}
