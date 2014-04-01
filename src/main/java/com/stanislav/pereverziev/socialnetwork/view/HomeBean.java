/*
 * This software is produced by EDB Business Partner AS. Unauthorized redistribution,
 * reproduction or usage of this software in whole or in part without
 * the express written consent of EDB Business Partner AS is strictly prohibited.
 * Copyright (C) 2010 EDB Business Partner AS. ALL RIGHTS RESERVED.
 */
package com.stanislav.pereverziev.socialnetwork.view;

import javax.enterprise.context.Conversation;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.IOException;
import java.io.Serializable;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 3/4/14
 */
@Named
@SessionScoped
public class HomeBean implements Serializable {
    @Inject
    private UserSession userSession;

    @Inject
    private Conversation conversation;

    public void init() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
        if (!userSession.isLoggedIn()) {
            try {
                FacesContext.getCurrentInstance().getExternalContext()
                        .redirect("login.jsf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String retrieveActiveStyle(String link) {
        String viewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
        link = "/pages/" + link + ".xhtml";
        if (link.equals(viewId)) {
            return "active";
        }
        return "";

    }

}
