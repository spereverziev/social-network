/*
 * This software is produced by EDB Business Partner AS. Unauthorized redistribution,
 * reproduction or usage of this software in whole or in part without
 * the express written consent of EDB Business Partner AS is strictly prohibited.
 * Copyright (C) 2010 EDB Business Partner AS. ALL RIGHTS RESERVED.
 */
package com.stanislav.pereverziev.socialnetwork.util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 3/3/14
 */
public class FacesUtil {
    public static void addError(String message) {
        addError(message, null);
    }

    public static void addError(String message, String compId) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                message, message);

        FacesContext.getCurrentInstance().addMessage(compId, msg);
    }

    public static String getParameter(String parameter) {
        Map<String, String> params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        return params.get(parameter);
    }

}
