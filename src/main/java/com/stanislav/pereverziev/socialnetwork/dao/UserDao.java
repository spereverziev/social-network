package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.entity.User;

import java.sql.SQLException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public interface UserDao {
    void addUser(User user) throws SQLException;
    void updateUser(User user) throws SQLException;
    User findUserById(int userId) throws SQLException;
    User findUserByEmail(String email) throws SQLException;
}
