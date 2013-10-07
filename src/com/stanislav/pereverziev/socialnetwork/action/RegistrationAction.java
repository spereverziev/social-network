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
import java.io.IOException;
import java.sql.SQLException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */
public class RegistrationAction implements Action {
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String CONFIRM_PASSWORD = "confirmPassword";
    public static final String FIRST_NAME = "firstName";
    public static final String LAST_NAME = "LastName";
    public static final String AGE = "age";
    public static final String EMAIL = "email";
    public static final String ERROR = "error";
    public static final String PASSWORD_ERROR = "Confirm password doesn't match password";
    public static final String REGISTRATION_JSP = "/jsp/registration.jsp";
    public static final String SQL_ERROR = "SQL exception. Plz contact administrator.";
    public static final String ERROR_JSP = "/jsp/error.jsp";
    private IUserDao userDao;
    private IAccountDao accountDao;
    private User user;
    private Account account;

    public RegistrationAction() {
        userDao = new UserDao();
        accountDao = new AccountDao();
        user = new User();
        account = new Account();
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page = null;
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String confirmPassword = request.getParameter(CONFIRM_PASSWORD);
        String firstName = request.getParameter(FIRST_NAME);
        String lastName = request.getParameter(LAST_NAME);
        Integer age = Integer.valueOf(request.getParameter(AGE));
        String email = request.getParameter(EMAIL);
        Integer userId = 0;

        if (!password.equals(confirmPassword)) {
            request.setAttribute(ERROR, PASSWORD_ERROR);
            return REGISTRATION_JSP;
        }

        initializeUser(login, password);

        try {
            userDao.addUser(user);
            userId = userDao.findUserByLogin(login).getId();
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute(ERROR, SQL_ERROR);
            page = ERROR_JSP;
        }

        initializeAccount(firstName, lastName, age, email, userId);

        try {
            accountDao.addAccount(account);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute(ERROR, SQL_ERROR);
            page = ERROR_JSP;
        }

        return page;
    }

    private void initializeAccount(String firstName, String lastName, Integer age, String email, Integer userId) {
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setAge(age);
        account.setEmail(email);
        account.setUserId(userId);
    }

    private void initializeUser(String login, String password) {
        user.setLogin(login);
        user.setPassword(password);
    }
}
