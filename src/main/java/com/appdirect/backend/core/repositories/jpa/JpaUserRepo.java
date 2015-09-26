package com.appdirect.backend.core.repositories.jpa;

import com.appdirect.backend.core.entities.User;
import com.appdirect.backend.core.repositories.UserRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

import static com.appdirect.backend.core.entities.User.QUERY_SELECT_ALL;
import static com.appdirect.backend.core.entities.User.QUERY_SELECT_BY_USERNAME;

/**
 * Created by cweerasekera
 */
@Repository
public class JpaUserRepo implements UserRepo {
    private static final Logger LOG = LoggerFactory.getLogger(JpaUserRepo.class);

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAllUsers() {
        Query query = em.createNamedQuery(QUERY_SELECT_ALL);
        return query.getResultList();
    }

    @Override
    public User findUser(String uuid) {
        return em.find(User.class, uuid);
    }

    @Override
    public User findUserByUserName(String username) {
        Query query = em.createNamedQuery(QUERY_SELECT_BY_USERNAME);
        query.setParameter(1, username);
        List<User> users = query.getResultList();
        if (users.size() == 0){
            return null;
        }else {
            return users.get(0);
        }
    }

    /*@Override
    public User findUserByOpenId(String openIdIdentifier) {
        Query query = em.createNamedQuery(QUERY_SELECT_BY_OPEN_ID);
        query.setParameter(1, openIdIdentifier);
        List<User> users = query.getResultList();
        if (users.size() == 0){
            return null;
        }else {
            return users.get(0);
        }
    }*/

    @Override
    public User createUser(User data) {
        em.persist(data);
        return data;
    }
}
