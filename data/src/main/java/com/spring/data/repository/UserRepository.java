package com.spring.data.repository;

import com.spring.data.entity.User;

/**
 * Created by mint on 8/19/18.
 */


public interface UserRepository {

    User findOne(Long id);

    User findOneByUsername(String username);

    User save(User user);

}
