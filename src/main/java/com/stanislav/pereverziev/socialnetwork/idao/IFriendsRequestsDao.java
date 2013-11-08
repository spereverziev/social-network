package com.stanislav.pereverziev.socialnetwork.idao;

import java.sql.SQLException;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/13/13
 */
public interface IFriendsRequestsDao {
    void addFriendsRequest(int fromUser, int toUser, int accountId);
    void acceptRequest(int requestId);
}
