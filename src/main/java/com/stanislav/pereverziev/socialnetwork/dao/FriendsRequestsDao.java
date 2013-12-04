package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.idao.IFriendsRequestsDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/13/13
 */
public class FriendsRequestsDao implements IFriendsRequestsDao {
    private EntityManager entityManager;
    private EntityManagerFactory factory;

    public FriendsRequestsDao() {
        factory = Persistence.createEntityManagerFactory("sn-pu");
        entityManager = factory.createEntityManager();
    }


    @Override
    public void addFriendsRequest(int fromUser, int toUser, int accountId) {

    }

    @Override
    public void acceptRequest(int requestId){
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
