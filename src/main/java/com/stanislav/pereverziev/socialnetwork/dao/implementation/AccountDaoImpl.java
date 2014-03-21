package com.stanislav.pereverziev.socialnetwork.dao.implementation;

import com.stanislav.pereverziev.socialnetwork.dao.AccountDao;
import com.stanislav.pereverziev.socialnetwork.entity.Account;
import com.stanislav.pereverziev.socialnetwork.entity.User;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
@Named
public class AccountDaoImpl  implements AccountDao {
    private EntityManagerFactory factory;
    private EntityManager entityManager;

    public AccountDaoImpl() {
        factory = Persistence.createEntityManagerFactory("jdbc/social-network");
        entityManager = factory.createEntityManager();
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
