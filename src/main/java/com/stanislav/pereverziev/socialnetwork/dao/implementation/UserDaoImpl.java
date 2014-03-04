package com.stanislav.pereverziev.socialnetwork.dao.implementation;

import com.stanislav.pereverziev.socialnetwork.dao.UserDao;
import com.stanislav.pereverziev.socialnetwork.entity.User;

import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/29/13
 */
@Named
public class UserDaoImpl extends DataAccessObject implements UserDao,Serializable {
    public UserDaoImpl() {
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
    public User findUserByEmail(String email) throws SQLException {
        return (User) entityManager.createNamedQuery("findByLogin").setParameter("email", email).getSingleResult();
    }

    @Override
    public List findAll() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
