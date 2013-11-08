package com.stanislav.pereverziev.socialnetwork.idao;

import com.stanislav.pereverziev.socialnetwork.entity.Account;
import com.stanislav.pereverziev.socialnetwork.entity.User;

import java.sql.SQLException;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public interface IAccountDao {
    public void addAccount(Account account) throws SQLException;
    public Account findAccountByUser(User user) throws SQLException;
    public List findAccountsByName(String name) throws SQLException;
    public List findAll();
}
