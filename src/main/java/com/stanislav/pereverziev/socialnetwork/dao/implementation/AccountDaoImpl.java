package com.stanislav.pereverziev.socialnetwork.dao.implementation;

import com.stanislav.pereverziev.socialnetwork.dao.AccountDao;
import com.stanislav.pereverziev.socialnetwork.entity.Account;
import com.stanislav.pereverziev.socialnetwork.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public class AccountDaoImpl extends DataAccessObject implements AccountDao {

    public AccountDaoImpl() {
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
