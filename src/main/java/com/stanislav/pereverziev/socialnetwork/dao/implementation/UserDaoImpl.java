package com.stanislav.pereverziev.socialnetwork.dao.implementation;

import com.stanislav.pereverziev.socialnetwork.dao.UserDao;
import com.stanislav.pereverziev.socialnetwork.entity.FriendsRequest;
import com.stanislav.pereverziev.socialnetwork.entity.User;
import com.stanislav.pereverziev.socialnetwork.util.DAOUtil;

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
    private EntityManager entityManager;

    public UserDaoImpl() {
        entityManager = DAOUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void addUser(User user) throws SQLException {
        entityManager.merge(user);
    }

    @Override
    public void updateUserFriends(User user) throws SQLException {
        User toUpdateUser = entityManager.find(User.class, user.getId());
        toUpdateUser.getAccount().setFriends(user.getAccount().getFriends());
        toUpdateUser.getAccount().setFriendsRequests(user.getAccount().getFriendsRequests());
        entityManager.merge(toUpdateUser);
    }

    public void updateFriendsRequest(FriendsRequest friendsRequest) {
        FriendsRequest request = entityManager.find(FriendsRequest.class, friendsRequest.getId());

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
