package com.stanislav.pereverziev.socialnetwork.servlet;

import com.stanislav.pereverziev.socialnetwork.action.Action;
import com.stanislav.pereverziev.socialnetwork.action.DefaultAction;
import com.stanislav.pereverziev.socialnetwork.action.LoginAction;
import com.stanislav.pereverziev.socialnetwork.action.LogoutAction;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */
public class ControllerHelper {
    private static ControllerHelper instance = new ControllerHelper();
    private Map<String, Action> actions = new HashMap<String, Action>();

    public ControllerHelper() {
        actions.put("login", new LoginAction());
        actions.put("logout", new LogoutAction());
        actions.put("default", new DefaultAction());
    }

    public Action getAction(HttpServletRequest request) {
        Action action = actions.get(request.getParameter("action"));
        if (action == null) {
            action = new DefaultAction();
        }
        return action;
    }

    public static ControllerHelper getInstance() {
        return instance;
    }
}
