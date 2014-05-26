package com.stanislav.pereverziev.socialnetwork.dao.implementation;

import com.stanislav.pereverziev.socialnetwork.dao.MessageDao;
import com.stanislav.pereverziev.socialnetwork.entity.Message;
import com.stanislav.pereverziev.socialnetwork.util.DAOUtil;

import javax.persistence.EntityManager;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */
public class MessageDaoImpl implements MessageDao {
    private EntityManager entityManager;

    public  MessageDaoImpl() {
        entityManager = DAOUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void addMessage(Message message) {
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
