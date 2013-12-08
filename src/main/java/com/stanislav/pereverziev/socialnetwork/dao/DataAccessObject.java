package com.stanislav.pereverziev.socialnetwork.dao;

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
        factory = Persistence.createEntityManagerFactory("sn-pu");
        entityManager = factory.createEntityManager();
    }
}
