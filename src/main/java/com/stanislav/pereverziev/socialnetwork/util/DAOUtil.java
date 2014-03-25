package com.stanislav.pereverziev.socialnetwork.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 3/25/14
 */
public class DAOUtil {
    private final static EntityManagerFactory factory = Persistence.createEntityManagerFactory("jdbc/social-network");

    public static EntityManagerFactory getEntityManagerFactory() {
        return factory;
    }
}
