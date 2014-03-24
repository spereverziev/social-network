package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.entity.Account;
import com.stanislav.pereverziev.socialnetwork.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public interface AccountDao {
    void addAccount(Account account) throws SQLException;
    Account findAccountByUser(User user) throws SQLException;
    List findAccountsByName(String name) throws SQLException;
    List findAccountsByFirstName(String name) throws SQLException;
    List findAccountsByLastName(String name) throws SQLException;
    List findAll();
}
