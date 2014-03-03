package com.stanislav.pereverziev.socialnetwork.dao.implementation;

import com.stanislav.pereverziev.socialnetwork.dao.AvatarDao;
import com.stanislav.pereverziev.socialnetwork.entity.Avatar;

/**
 * User: Stanislav.Pereverziev
 * Date: 12/4/13
 */
public class AvatarDaoImpl extends DataAccessObject implements AvatarDao {

    @Override
    public void saveAvatar(Avatar avatar) {
        entityManager.persist(avatar);
    }
}

