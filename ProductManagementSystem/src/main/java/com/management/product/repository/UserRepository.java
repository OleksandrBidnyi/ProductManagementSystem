package com.management.product.repository;

import com.management.product.entity.User;
import com.management.product.enums.UserRole;

import java.util.Collection;

/**
 * Created by Aleksandr on 09.08.2017.
 */
public interface UserRepository extends DataRepository<User> {

    User findByUsername(String username);

    void deleteByUsername(String username);

    Collection<User> findAllByRole(UserRole userRole);
}
