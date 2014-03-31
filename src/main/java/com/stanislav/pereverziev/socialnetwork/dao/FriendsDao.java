package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.entity.FriendsRequest;
import com.stanislav.pereverziev.socialnetwork.entity.RequestStatus;

import java.util.List;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 3/24/14
 */
public interface FriendsDao {
    void addFriend(int accountId, int userId);
    void updateFriendsRequestStatus(FriendsRequest friendsRequest, RequestStatus requestStatus);
    List<FriendsRequest> getSentFriendsRequests(int senderId);

}
