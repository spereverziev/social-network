package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public interface UserDao {
    void addUser(User user) throws SQLException;
    User findUserById(int userId) throws SQLException;
    User findUserByLogin(String login) throws SQLException;
    List findAll();
}
