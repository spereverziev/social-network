package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.entity.Message;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */
public interface MessageDao {
    void addMessage(Message message);
    Message findMessage(int id);
    Message[] findAll();
}
