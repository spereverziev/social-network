package com.stanislav.pereverziev.socialnetwork.view;

import com.stanislav.pereverziev.socialnetwork.controller.MessageController;
import com.stanislav.pereverziev.socialnetwork.dao.UserDao;
import com.stanislav.pereverziev.socialnetwork.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

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

    @Inject
    private MessageController messageController;


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
            return messageController.retrieveReceiver();
        }
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }


    public void sendMessage() {
        messageController.sendMessage(message,receiver);
    }
}
