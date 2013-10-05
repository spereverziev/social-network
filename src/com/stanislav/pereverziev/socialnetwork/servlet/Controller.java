package com.stanislav.pereverziev.socialnetwork.servlet;

import com.stanislav.pereverziev.socialnetwork.action.Action;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */
public class Controller extends HttpServlet {
    private ActionFactory actionFactory = ActionFactory.getInstance();

    public Controller() {
        super();
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String page = null;
        try {
            Action action = actionFactory.getAction(request);
            page = action.execute(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
            request.setAttribute("messageError", "Servlet exception");

        } catch (IOException e) {
            e.printStackTrace();
            request.setAttribute("messageError", "Input or output error");

        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

}
