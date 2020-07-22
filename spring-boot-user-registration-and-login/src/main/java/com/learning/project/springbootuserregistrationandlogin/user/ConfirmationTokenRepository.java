package com.learning.project.springbootuserregistrationandlogin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author TatianaSamsonova
 * @created 22/07/2020 - 10:08 AM
 * @project spring-boot-user-registration-and-login
 */

@Repository
public interface ConfirmationTokenRepository extends CrudRepository<ConfirmationToken, Long> {

    Optional<ConfirmationToken> findConfirmationTokenByConfirmationToken(String token);
}
