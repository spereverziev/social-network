package com.stanislav.pereverziev.socialnetwork.entity;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 3/21/14
 */
public enum RequestStatus {
    ACCEPTED("ACCEPTED"),
    DISMISSED("DISMISSED"),
    NEW("NEW");

    private String value;

    RequestStatus(String value) {
        this.value = this.value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
