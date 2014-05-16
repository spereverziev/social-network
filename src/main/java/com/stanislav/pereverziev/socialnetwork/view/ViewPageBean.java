package com.stanislav.pereverziev.socialnetwork.view;

import com.stanislav.pereverziev.socialnetwork.dao.UserDao;
import com.stanislav.pereverziev.socialnetwork.entity.User;
import com.stanislav.pereverziev.socialnetwork.util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * User: Stanislav.Pereverziev
 * Date: 3/18/14
 */
@Named
@RequestScoped
public class ViewPageBean implements Serializable {

    @Inject
    private UserDao userDao;

    public User getViewUser() {
        String userId = FacesUtil.getParameter("userId");
        User user = null;
        if (userId != null) {
            try {
                user = userDao.findUserById(Integer.valueOf(userId));
            } catch (SQLException e) {
                FacesUtil.addError("No such user");
            }
        } else {
            try {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("home.jsf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
