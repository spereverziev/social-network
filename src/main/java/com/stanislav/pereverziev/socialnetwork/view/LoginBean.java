/*
 * This software is produced by EDB Business Partner AS. Unauthorized redistribution,
 * reproduction or usage of this software in whole or in part without
 * the express written consent of EDB Business Partner AS is strictly prohibited.
 * Copyright (C) 2010 EDB Business Partner AS. ALL RIGHTS RESERVED.
 */
package com.stanislav.pereverziev.socialnetwork.view;

import com.stanislav.pereverziev.socialnetwork.dao.UserDao;
import com.stanislav.pereverziev.socialnetwork.entity.User;
import com.stanislav.pereverziev.socialnetwork.util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 3/3/14
 */
@Named("loginBean")
@RequestScoped
public class LoginBean implements Serializable {

    private String email;
    private String password;

    @Inject
    private UserDao userDao;

    @Inject
    private UserSession userSession;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() {
        if (email == null || password == null) {
            FacesUtil.addError("Incorrect email/password");
        } else {
            try {
                User user = userDao.findUserByEmail(email);
                userSession.setUser(user);
                return "/pages/home.jsf";
            } catch (SQLException e) {
                FacesUtil.addError("SQL Error");
                e.printStackTrace();
            }
        }
        return null;
    }

}
