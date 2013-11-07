package com.stanislav.pereverziev.socialnetwork.idao;

import com.stanislav.pereverziev.socialnetwork.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public interface IUserDao {
    public void addUser(User user) throws SQLException;
    public User findUserById(int userId) throws SQLException;
    public User findUserByLogin(String login) throws SQLException;
    public List findAll();
}
