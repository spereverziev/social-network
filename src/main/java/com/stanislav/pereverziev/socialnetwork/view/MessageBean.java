package com.stanislav.pereverziev.socialnetwork.view;

import com.stanislav.pereverziev.socialnetwork.dao.UserDao;
import com.stanislav.pereverziev.socialnetwork.entity.User;
import com.stanislav.pereverziev.socialnetwork.util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 4/30/14
 */
@Named
@RequestScoped
public class MessageBean implements Serializable {
    private String message;
    private User receiver;

    @Inject
    private UserDao userDao;

    public User retrieveReceiver() {
        String receiverId = FacesUtil.getParameter("receiverId");
        if (receiverId == null) {
            return null;
        }
        try {
            return userDao.findUserById(Integer.valueOf(receiverId));
        } catch (SQLException e) {
            FacesUtil.addError("No such user");
        }
        return null;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public User getReceiver() {
        if (receiver != null) {
            return receiver;
        } else {
            return retrieveReceiver();
        }
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
}
