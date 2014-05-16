package com.stanislav.pereverziev.socialnetwork.controller;

import com.stanislav.pereverziev.socialnetwork.dao.FriendsDao;
import com.stanislav.pereverziev.socialnetwork.dao.UserDao;
import com.stanislav.pereverziev.socialnetwork.entity.FriendsRequest;
import com.stanislav.pereverziev.socialnetwork.entity.RequestStatus;
import com.stanislav.pereverziev.socialnetwork.entity.User;
import com.stanislav.pereverziev.socialnetwork.util.FacesUtil;
import com.stanislav.pereverziev.socialnetwork.view.UserSession;

import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public void acceptRequest() {
        String friendId = FacesUtil.getParameter("newFriendId");
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

    public void dismissRequest() {
        String friendId = FacesUtil.getParameter("newFriendId");
        List<FriendsRequest> friendsRequests = userSession.getUser().getAccount().getFriendsRequests();
        changeRequestStatus(friendsRequests, Integer.valueOf(friendId), RequestStatus.DISMISSED);
    }

    public boolean isFriend(String searchUserId) {
        List<User> friends = userSession.getUser().getAccount().getFriends();
        try {
            User searchUser = userDao.findUserById(Integer.valueOf(searchUserId));
            if (friends.contains(searchUser)) {
                return true;
            }
        } catch (SQLException e) {
            FacesUtil.addError("SQL Error");
            e.printStackTrace();
        }
        return false;
    }

    public boolean isSentFriendsRequest(String searchUserId) {
        List<FriendsRequest> sentFriendsRequests = friendsDao.getSentFriendsRequests(userSession.getUser().getId());
        for (FriendsRequest sentFriendsRequest : sentFriendsRequests) {
            if (Integer.valueOf(searchUserId) == sentFriendsRequest.getReceiver().getId()) {
                if (sentFriendsRequest.getStatus().equals(RequestStatus.NEW)) {
                    return true;
                }
            }
        }

        return false;
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
