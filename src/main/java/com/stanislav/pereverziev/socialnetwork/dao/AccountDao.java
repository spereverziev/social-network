package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.entity.Account;
import com.stanislav.pereverziev.socialnetwork.entity.User;
import com.stanislav.pereverziev.socialnetwork.idao.IAccountDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public class AccountDao extends DataAccessObject implements IAccountDao {

    public AccountDao() {
    }

    @Override
    public void addAccount(Account account) throws SQLException {
        entityManager.persist(account);
    }

    @Override
    public Account findAccountByUser(User user) {
        return (Account) entityManager.createNamedQuery("findByUser").setParameter("user", user).getSingleResult();
    }

    @Override
    public List findAccountsByName(String name) throws SQLException {
        List<Account> accounts = entityManager.createNamedQuery("findByName").setParameter("name",name).getResultList();
        return accounts;
    }

    @Override
    public List findAll() {
        return null;
    }
}
