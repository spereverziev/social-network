package com.stanislav.pereverziev.socialnetwork.dao.implementation;

import com.stanislav.pereverziev.socialnetwork.dao.UserDao;
import com.stanislav.pereverziev.socialnetwork.entity.User;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/29/13
 */
@Named
public class UserDaoImpl implements UserDao {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public UserDaoImpl() {
        factory = Persistence.createEntityManagerFactory("jdbc/social-network");
        entityManager = factory.createEntityManager();
    }

    @Override
    public void addUser(User user) throws SQLException {
        entityManager.merge(user);
    }

    @Override
    public void updateUser(User user) throws SQLException {
        entityManager.getTransaction().begin();
        entityManager.merge(user);
        entityManager.flush();
        entityManager.getTransaction().commit();
    }

    @Override
    public User findUserById(int userId) throws SQLException {
        return entityManager.find(User.class, userId);
    }

    @Override
    public User findUserByEmail(String email) throws SQLException {
        return (User) entityManager.createNamedQuery("findByLogin").setParameter("email", email).getSingleResult();
    }
}
