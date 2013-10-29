package com.stanislav.pereverziev.socialnetwork.idao;

import com.stanislav.pereverziev.socialnetwork.entity.Message;

/**
 * User: Stanislav.Pereverziev
 * Date: 10/5/13
 */
public interface IMessageDao {
    public void addMessage(int from_user, int to_user, String text);
    public Message findMessage(int id);
    public Message[] findAll();
}
