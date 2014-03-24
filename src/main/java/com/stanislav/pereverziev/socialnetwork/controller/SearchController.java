package com.stanislav.pereverziev.socialnetwork.controller;

import com.stanislav.pereverziev.socialnetwork.dao.AccountDao;
import com.stanislav.pereverziev.socialnetwork.entity.Account;

import javax.inject.Inject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 3/24/14
 */
public class SearchController {
    @Inject
    private AccountDao accountDao;

    public List<Account> search(String fieldValue) throws SQLException {
        List<Account> searchResult = new ArrayList<Account>();
        String[] searchVariables = fieldValue.split(" ");

        List accountsByName = accountDao.findAccountsByName(fieldValue);
        if (!accountsByName.isEmpty()) {
            searchResult.addAll(accountsByName);
        }

        for (String variable : searchVariables) {
            List accountsByLastName = accountDao.findAccountsByLastName(variable);
            if (!accountsByLastName.isEmpty()) {
                searchResult.addAll(accountsByLastName);
            }
        }
        return searchResult;
    }

}
