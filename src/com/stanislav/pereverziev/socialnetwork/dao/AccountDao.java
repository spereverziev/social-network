package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.ConnectionFactory;
import com.stanislav.pereverziev.socialnetwork.entity.Account;
import com.stanislav.pereverziev.socialnetwork.idao.IAccountDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public class AccountDao implements IAccountDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    @Override
    public void addAccount(Account account) throws SQLException {
        String query = "INSERT INTO accounts(first_name, last_name, email, age, user_id) VALUES(?,?)";
        connection = getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, account.getFirstName());
        preparedStatement.setString(2, account.getLastName());
        preparedStatement.setString(3, account.getEmail());
        preparedStatement.setInt(4, account.getAge());
        preparedStatement.setInt(5, account.getUserId());
        preparedStatement.executeUpdate();
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void findAccount(int account_id) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void findAccountByName(String name) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void findAll() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
