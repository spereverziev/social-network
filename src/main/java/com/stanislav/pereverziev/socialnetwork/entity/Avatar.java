package com.stanislav.pereverziev.socialnetwork.entity;

import javax.persistence.*;

/**
 * User: Stanislav.Pereverziev
 * Date: 12/4/13
 */
@Entity
@Table(name = "avatars")
public class Avatar implements java.io.Serializable {
    @Id
    @GeneratedValue
    private Integer avatarId;
    private byte[] image;

    public Avatar() {
    }

    public Avatar(byte[] image) {
        this.image = image;
    }

    public Integer getAvatarId() {
        return this.avatarId;
    }

    public void setAvatarId(Integer avatarId) {
        this.avatarId = avatarId;
    }

    public byte[] getImage() {
        return this.image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}