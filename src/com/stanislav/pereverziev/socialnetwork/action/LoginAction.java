package com.stanislav.pereverziev.socialnetwork.action;

import com.stanislav.pereverziev.socialnetwork.dao.AccountDao;
import com.stanislav.pereverziev.socialnetwork.dao.UserDao;
import com.stanislav.pereverziev.socialnetwork.entity.Account;
import com.stanislav.pereverziev.socialnetwork.entity.User;
import com.stanislav.pereverziev.socialnetwork.idao.IAccountDao;
import com.stanislav.pereverziev.socialnetwork.idao.IUserDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */
public class LoginAction implements Action {
    public static final String USER = "user";
    public static final String MAIN_JSP = "/jsp/main.jsp";
    public static final String ERROR = "error";
    public static final String ERROR_JSP = "/jsp/error.jspx";
    public static final String WRONG_PASSWORD = "Wrong password!";
    public static final String NO_SUCH_USER = "No such user";
    private IUserDao userDao = new UserDao();
    private IAccountDao accountDao = new AccountDao();
    private User user = new User();
    private Account account = new Account();

    private static final String LOGIN = "login";
    private static final String PASSWORD = "password";

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);

        HttpSession session = request.getSession(true);
        try {
            user = userDao.findUserByLogin(login);
            if (user.getPassword().equals(password)) {
                account = accountDao.findAccountByUser(user);
                session.setAttribute("account", account);
                session.setAttribute(USER, login);
                page = MAIN_JSP;
            } else {
                session.setAttribute(ERROR, WRONG_PASSWORD);
                page = ERROR_JSP;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            session.setAttribute(ERROR, NO_SUCH_USER);
            page = ERROR_JSP;
        }

        return page;
    }
}
