package com.spring.data.repository;

import com.spring.data.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by mint on 8/19/18.
 */

@Repository
public class UserRepositoryImpl extends BaseRepository implements UserRepository {

    @Override
    public User findOne(Long id) {
        return (User) entityManager.createQuery("select u from User u where id = ?1").
                setParameter(1, id).
                getSingleResult();
    }


    public User findOneByUsername(String username) {
        return (User) entityManager.createQuery("select u from User u where username = ?1").
                setParameter(1, username).
                getSingleResult();
    }

    @Override
    public User save(User user) {
        entityManager.persist(user);
        return null;
    }
}
