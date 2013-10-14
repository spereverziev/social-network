package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.ConnectionFactory;
import com.stanislav.pereverziev.socialnetwork.entity.FriendsRequest;
import com.stanislav.pereverziev.socialnetwork.idao.IFriendsRequestsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/13/13
 */
public class FriendsRequestsDao implements IFriendsRequestsDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    private Connection getConnection() throws SQLException {
        Connection conn;
        conn = ConnectionFactory.getInstance().getConnection();
        return conn;
    }

    @Override
    public void addFriendsRequest(int fromUser, int toUser, int accountId) throws SQLException {
        String query = "INSERT INTO friends_requests(from_user, to_user, is_accepted, account_id) VALUES(?,?,?,?)";
        connection = getConnection();
        preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, fromUser);
        preparedStatement.setInt(2, toUser);
        preparedStatement.setInt(3, -1);
        preparedStatement.setInt(4, accountId);
        preparedStatement.executeUpdate();
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void acceptRequest(int requestId) throws SQLException {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
