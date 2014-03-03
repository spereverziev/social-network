package com.stanislav.pereverziev.socialnetwork.dao.implementation;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * User: Stanislav.Pereverziev
 * Date: 12/4/13
 */
public abstract class DataAccessObject {
    protected EntityManager entityManager;
    protected EntityManagerFactory factory;

    public DataAccessObject() {
        factory = Persistence.createEntityManagerFactory("jdbc/social-network");
        entityManager = factory.createEntityManager();
    }
}
