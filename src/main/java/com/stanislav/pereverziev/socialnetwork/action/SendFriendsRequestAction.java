package com.stanislav.pereverziev.socialnetwork.action;

import com.stanislav.pereverziev.socialnetwork.dao.FriendsRequestsDao;
import com.stanislav.pereverziev.socialnetwork.entity.Account;
import com.stanislav.pereverziev.socialnetwork.entity.FriendsRequest;
import com.stanislav.pereverziev.socialnetwork.idao.IFriendsRequestsDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/15/13
 */
public class SendFriendsRequestAction implements Action {
    private IFriendsRequestsDao friendsRequestsDao;
    private FriendsRequest friendsRequest;

    public SendFriendsRequestAction() {
        friendsRequestsDao = new FriendsRequestsDao();
        friendsRequest = new FriendsRequest();
    }

    @Override

    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String page;
        Account myAccount = (Account) request.getSession().getAttribute("account");
        Account friendAccount = (Account) request.getAttribute("friendsRequestAccount");
        try {
            friendsRequestsDao.addFriendsRequest(myAccount.getUserId(), friendAccount.getUserId(), myAccount.getId());
            page = "/jsp/main.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            page = "/jsp/error.jsp";
        }

        return page;
    }
}
