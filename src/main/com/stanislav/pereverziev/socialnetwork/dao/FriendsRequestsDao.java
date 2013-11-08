package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.ConnectionFactory;
import com.stanislav.pereverziev.socialnetwork.entity.Account;
import com.stanislav.pereverziev.socialnetwork.entity.FriendsRequest;
import com.stanislav.pereverziev.socialnetwork.idao.IFriendsRequestsDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List findAll() throws SQLException {
        List<FriendsRequest> friendsRequests = new ArrayList<FriendsRequest>();

        FriendsRequest friendsRequest;
        String query = "SELECT * FROM friends_requests WHERE friends_requests.is_accepted != '1'";
        connection = getConnection();
        preparedStatement = connection.prepareStatement(query);
        resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            friendsRequest = new FriendsRequest();
            friendsRequest.setFromUser(resultSet.getInt(1));
            friendsRequest.setToUser(resultSet.getInt(2));
            friendsRequest.setAccepted(resultSet.getInt(3) == 1);
            friendsRequest.setAccountId(resultSet.getInt(4));

            friendsRequests.add(friendsRequest);
        }

        try {
            preparedStatement.close();
            connection.close();
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return friendsRequests;
    }
}
