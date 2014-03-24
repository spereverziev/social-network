package com.stanislav.pereverziev.socialnetwork.controller;

import com.stanislav.pereverziev.socialnetwork.dao.FriendsDao;
import com.stanislav.pereverziev.socialnetwork.dao.UserDao;
import com.stanislav.pereverziev.socialnetwork.entity.FriendsRequest;
import com.stanislav.pereverziev.socialnetwork.entity.RequestStatus;
import com.stanislav.pereverziev.socialnetwork.entity.User;
import com.stanislav.pereverziev.socialnetwork.util.FacesUtil;
import com.stanislav.pereverziev.socialnetwork.view.UserSession;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 3/19/14
 */
@Named
public class FriendsController implements Serializable {
    @Inject
    private UserDao userDao;
    @Inject
    private UserSession userSession;
    @Inject
    private FriendsDao friendsDao;

    public void addFriend() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String friendId = params.get("newFriendId");
        User user = userSession.getUser();
        List<User> friends = user.getAccount().getFriends();
        List<FriendsRequest> friendsRequests = user.getAccount().getFriendsRequests();
        try {
            User newFriend = userDao.findUserById(Integer.valueOf(friendId));
            if (!friends.contains(newFriend)) {
                friends.add(newFriend);
                changeRequestStatus(friendsRequests, newFriend.getId(), RequestStatus.ACCEPTED);
                friendsDao.addFriend(user.getAccount().getId(),newFriend.getId());

            } else {
                FacesUtil.addError("Constraint validation. User already in your friends list.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void changeRequestStatus(List<FriendsRequest> friendsRequests, int senderId, RequestStatus requestStatus) {
        for (FriendsRequest friendsRequest : friendsRequests) {
            if (friendsRequest.getSender().getId() == senderId) {
                friendsRequest.setStatus(requestStatus);
                friendsDao.updateFriendsRequestStatus(friendsRequest,requestStatus);
            }
        }
    }

    public List<User> getNewFriendsRequests() {
        List<FriendsRequest> friendsRequests = userSession.getUser().getAccount().getFriendsRequests();
        List<User> newRequests = new ArrayList<User>();
        for (FriendsRequest friendsRequest : friendsRequests) {
            if(friendsRequest.getStatus().equals(RequestStatus.NEW)) {
                newRequests.add(friendsRequest.getSender());
            }
        }
        return newRequests;
    }
}
