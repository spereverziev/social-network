package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.ConnectionFactory;
import com.stanislav.pereverziev.socialnetwork.entity.User;
import com.stanislav.pereverziev.socialnetwork.idao.IUserDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public class UserDao implements IUserDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    @Override
    public void addUser(String login, String password) throws SQLException {
        connection = getConnection();

    }

    @Override
    public User findUser(int userId) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public User[] findAll() {
        return new User[0];  //To change body of implemented methods use File | Settings | File Templates.
    }
}
