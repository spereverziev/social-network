package com.stanislav.pereverziev.socialnetwork.idao;

import java.sql.SQLException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/13/13
 */
public interface IFriendsRequestsDao {
    public void addFriendsRequest(int fromUser, int toUser, int accountId) throws SQLException;
    public void acceptRequest(int requestId) throws SQLException;
}
