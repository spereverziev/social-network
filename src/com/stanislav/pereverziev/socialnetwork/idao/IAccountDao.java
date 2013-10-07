package com.stanislav.pereverziev.socialnetwork.idao;

import com.stanislav.pereverziev.socialnetwork.entity.Account;

import java.sql.SQLException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public interface IAccountDao {
    public void addAccount(Account account) throws SQLException;
    public void findAccount(int account_id);
    public void findAccountByName(String name);
    public void findAll();
}
