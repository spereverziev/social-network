package com.stanislav.pereverziev.socialnetwork.idao;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/3/13
 */
public interface IAccountDao {
    public void addAccount(String name, int age, int user_id);
    public void findAccount(int account_id);
    public void findAll();
}
