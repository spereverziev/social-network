package com.stanislav.pereverziev.socialnetwork.action;

import com.stanislav.pereverziev.socialnetwork.dao.FriendsRequestsDao;
import com.stanislav.pereverziev.socialnetwork.entity.Account;
import com.stanislav.pereverziev.socialnetwork.entity.FriendsRequest;
import com.stanislav.pereverziev.socialnetwork.idao.IFriendsRequestsDao;
import com.stanislav.pereverziev.socialnetwork.util.Constants;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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
        Account myAccount = (Account) request.getSession().getAttribute(Constants.ATTRIBUTE_ACCOUNT);
        Account friendAccount = (Account) request.getAttribute(Constants.ATTRIBUTE_FRIENDS_REQUEST_ACCOUNT);

        friendsRequestsDao.addFriendsRequest(1, 1, myAccount.getId());
        page = Constants.MAIN_JSP;

        return page;
    }
}
