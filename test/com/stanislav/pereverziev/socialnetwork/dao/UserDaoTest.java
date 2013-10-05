package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.idao.IUserDao;
import org.junit.Before;
import org.junit.Test;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */
public class UserDaoTest {
    IUserDao userDao;

    @Before
    public void initialize() {
        userDao = new UserDao();
    }

    @Test
    public void testAddUser() throws Exception {
        userDao.addUser("root","root");
    }

    @Test
    public void testFindUser() throws Exception {

    }

    @Test
    public void testFindAll() throws Exception {

    }
}
