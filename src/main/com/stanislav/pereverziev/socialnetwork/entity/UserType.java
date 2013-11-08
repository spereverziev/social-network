package com.stanislav.pereverziev.socialnetwork.entity;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/6/13
 */
public enum UserType {
    ADMINISTRATOR("ADMINISTRATOR"),
    USER("USER");

    UserType(String id) {
        this.id = id;
    }
    private String id;

    public String getId() {
        return id;
    }
}
