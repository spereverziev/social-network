package com.stanislav.pereverziev.socialnetwork.dao;

import com.stanislav.pereverziev.socialnetwork.entity.Avatar;
import com.stanislav.pereverziev.socialnetwork.idao.IAvatarDao;

/**
 * User: Stanislav.Pereverziev
 * Date: 12/4/13
 */
public class AvatarDao extends DataAccessObject implements IAvatarDao {

    @Override
    public void saveAvatar(Avatar avatar) {
        entityManager.persist(avatar);
    }
}

