package com.stanislav.pereverziev.socialnetwork.controller;

import com.stanislav.pereverziev.socialnetwork.dao.UserDao;
import com.stanislav.pereverziev.socialnetwork.entity.RequestStatus;
import com.stanislav.pereverziev.socialnetwork.entity.friendRequest.FriendsRequest;
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
    
    public List<User> newFriendsRequests;

    public String  addFriend() {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String friendId = params.get("newFriendId");
        User user = userSession.getUser();
        List<User> friends = user.getAccount().getFriends();
        List<FriendsRequest> friendsRequests = user.getAccount().getFriendsRequests();
        try {
            User newFriend = userDao.findUserById(Integer.valueOf(friendId));
            if (!friends.contains(newFriend)) {
                friends.add(newFriend);
                userDao.updateUser(user);
            } else {
                FacesUtil.addError("Constraint validation. User already in your friends list.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/pages/friends.xhtml";
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
