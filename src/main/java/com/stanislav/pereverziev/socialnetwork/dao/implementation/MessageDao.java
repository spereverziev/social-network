package com.stanislav.pereverziev.socialnetwork.dao.implementation;

import com.stanislav.pereverziev.socialnetwork.entity.Message;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */
public class MessageDao extends DataAccessObject implements com.stanislav.pereverziev.socialnetwork.dao.MessageDao {
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
