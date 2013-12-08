package com.stanislav.pereverziev.socialnetwork.action;


import com.stanislav.pereverziev.socialnetwork.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Stanislav.Pereverziev
 * Date: 11/8/13
 */
public class ShowFriendsAction implements Action {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return Constants.FRIENDS_JSP;
    }
}
