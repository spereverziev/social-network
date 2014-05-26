package com.stanislav.pereverziev.socialnetwork.controller;

import com.stanislav.pereverziev.socialnetwork.dao.MessageDao;
import com.stanislav.pereverziev.socialnetwork.dao.UserDao;
import com.stanislav.pereverziev.socialnetwork.entity.Message;
import com.stanislav.pereverziev.socialnetwork.entity.User;
import com.stanislav.pereverziev.socialnetwork.util.FacesUtil;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 3/24/14
 */
@Named
public class MessageController {

    @Inject
    private UserDao userDao;

    @Inject
    private MessageDao messageDao;

    public User retrieveReceiver() {
        String receiverId = FacesUtil.getParameter("receiverId");
        if (receiverId == null) {
            return null;
        }
        try {
            return userDao.findUserById(Integer.valueOf(receiverId));
        } catch (SQLException e) {
            FacesUtil.addError("SQL Error. No such user");
        }
        return null;
    }

    public void sendMessage(String messageText, User receiver) {
        Message message = new Message();
        DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date date = new Date();

        message.setReceiver(receiver);
        message.setText(messageText);
        try {
            message.setDate(df.parse(String.valueOf(date)));
        } catch (ParseException e) {
           FacesUtil.addError("Sending message. Date parsing exception.");
        }


    }

}
