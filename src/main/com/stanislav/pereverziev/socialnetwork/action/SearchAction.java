package com.stanislav.pereverziev.socialnetwork.action;

import com.stanislav.pereverziev.socialnetwork.dao.AccountDao;
import com.stanislav.pereverziev.socialnetwork.idao.IAccountDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/13/13
 */
public class SearchAction implements Action {
    private IAccountDao accountDao;
    private List accounts;

    public SearchAction() {
        accountDao = new AccountDao();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String name = request.getParameter("name");
        HttpSession session = request.getSession();
        try {
            accounts = accountDao.findAccountsByName(name);
            session.setAttribute("accounts", accounts);
            page = "/jsp/search.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            session.setAttribute("error", "SQL error");
            page = "/jsp/error.jsp";
        }

        return page;
    }
}
