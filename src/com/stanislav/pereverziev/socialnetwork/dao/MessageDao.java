package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.entity.Message;
import com.stanislav.pereverziev.socialnetwork.idao.IMessageDao;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */
public class MessageDao implements IMessageDao {
    @Override
    public void addMessage(int from_user, int to_user, String text) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Message findMessage(int id) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Message[] findAll() {
        return new Message[0];  //To change body of implemented methods use File | Settings | File Templates.
    }
}
