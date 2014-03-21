package com.stanislav.pereverziev.socialnetwork.dao.implementation;

import com.stanislav.pereverziev.socialnetwork.dao.AvatarDao;
import com.stanislav.pereverziev.socialnetwork.entity.Avatar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: Stanislav.Pereverziev
 * Date: 12/4/13
 */
public class AvatarDaoImpl  implements AvatarDao {
    protected EntityManager entityManager;
    protected EntityManagerFactory factory;

    public AvatarDaoImpl() {
        factory = Persistence.createEntityManagerFactory("jdbc/social-network");
        entityManager = factory.createEntityManager();
    }

    @Override
    public void saveAvatar(Avatar avatar) {
        entityManager.persist(avatar);
    }
}

