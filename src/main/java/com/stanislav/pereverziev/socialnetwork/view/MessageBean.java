package com.stanislav.pereverziev.socialnetwork.view;

import com.stanislav.pereverziev.socialnetwork.entity.User;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 4/30/14
 */
@Named
@RequestScoped
public class MessageBean implements Serializable {
    private String message;
    private User receiver;

}
