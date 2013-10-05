package com.stanislav.pereverziev.socialnetwork.idao;

import com.stanislav.pereverziev.socialnetwork.entity.User;

import java.sql.SQLException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public interface IUserDao {
    public void addUser(String login, String password) throws SQLException;
    public User findUser(int userId);
    public User[] findAll();
}
