package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.entity.User;
import com.stanislav.pereverziev.socialnetwork.idao.IUserDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/29/13
 */
public class UserDao implements IUserDao {
    EntityManager entityManager;
    EntityManagerFactory factory;

    public UserDao() {
        factory = Persistence.createEntityManagerFactory("sn-pu");
        entityManager = factory.createEntityManager();
    }

    @Override
    public void addUser(User user) throws SQLException {
        entityManager.merge(user);
    }

    @Override
    public User findUserById(int userId) throws SQLException {
        return entityManager.find(User.class, userId);
    }

    @Override
    public User findUserByLogin(String login) throws SQLException {
        return (User) entityManager.createNamedQuery("findByLogin").setParameter("login", login).getSingleResult();
    }

    @Override
    public List findAll() {

        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
