package com.stanislav.pereverziev.socialnetwork.view;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 3/24/14
 */
@Named
public class SearchBean {
    @Inject
    private UserSession userSession;

    private String searchField;

    public String getSearchField() {
        return searchField;
    }

    public void setSearchField(String searchField) {
        this.searchField = searchField;
    }

    public String search() {

        return "/pages/search.jsf";
    }

}
