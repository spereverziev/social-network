package com.stanislav.pereverziev.socialnetwork.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/6/13
 */
public interface Action {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException;
}
