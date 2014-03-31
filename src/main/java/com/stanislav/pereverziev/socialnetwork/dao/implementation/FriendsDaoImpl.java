package com.stanislav.pereverziev.socialnetwork.dao.implementation;

import com.stanislav.pereverziev.socialnetwork.dao.FriendsDao;
import com.stanislav.pereverziev.socialnetwork.entity.FriendsRequest;
import com.stanislav.pereverziev.socialnetwork.entity.RequestStatus;
import com.stanislav.pereverziev.socialnetwork.util.DAOUtil;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by e212232 (Stanislav Pereverziev) .
 * on 3/24/14
 */
@Named
public class FriendsDaoImpl implements FriendsDao {
    private EntityManager entityManager;

    public FriendsDaoImpl() {
        entityManager = DAOUtil.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public void addFriend(int accountId,int userId) {
        String query = "insert into friends values(?,?)";
        entityManager.getTransaction().begin();
        entityManager.createNativeQuery(query)
                .setParameter(1, accountId)
                .setParameter(2, userId)
                .executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public void updateFriendsRequestStatus(FriendsRequest friendsRequest, RequestStatus requestStatus) {
        FriendsRequest request = entityManager.find(FriendsRequest.class, friendsRequest.getId());
        request.setStatus(requestStatus);
        entityManager.merge(request);
    }

    @Override
    public List<FriendsRequest> getSentFriendsRequests(int senderId) {
        TypedQuery<FriendsRequest> query =
                entityManager.createQuery("SELECT fr FROM FriendsRequest fr WHERE fr.sender.id = :senderId", FriendsRequest.class);
        query.setParameter("senderId", senderId);

        List<FriendsRequest> results = query.getResultList();

        return results;
    }


}
