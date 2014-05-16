package com.stanislav.pereverziev.socialnetwork.view;

import com.stanislav.pereverziev.socialnetwork.controller.SearchController;
import com.stanislav.pereverziev.socialnetwork.dao.AccountDao;
import com.stanislav.pereverziev.socialnetwork.entity.Account;
import com.stanislav.pereverziev.socialnetwork.util.FacesUtil;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 3/24/14
 */
@Named
@RequestScoped
public class SearchBean {
    @Inject
    private UserSession userSession;
    @Inject
    private SearchController searchController;

    private String searchField;
    private List<Account> searchResult;

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String search() {
        try {
            searchResult = searchController.search(searchField);
        } catch (SQLException e) {
            FacesUtil.addError("SQL Error");
            e.printStackTrace();
        }
        return "/pages/searchPage.jsf";
    }

    public List<Account> getSearchResult() {
        return searchResult;
    }
}
