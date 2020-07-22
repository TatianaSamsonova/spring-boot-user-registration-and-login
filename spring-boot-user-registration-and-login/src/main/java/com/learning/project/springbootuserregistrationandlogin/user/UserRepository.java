package com.learning.project.springbootuserregistrationandlogin.user;

import com.learning.project.springbootuserregistrationandlogin.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author TatianaSamsonova
 * @created 22/07/2020 - 9:19 AM
 * @project spring-boot-user-registration-and-login
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
