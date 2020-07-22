package com.learning.project.springbootuserregistrationandlogin.user;

import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author TatianaSamsonova
 * @created 22/07/2020 - 10:14 AM
 * @project spring-boot-user-registration-and-login
 */

@Service
class ConfirmationTokenService {

    private final ConfirmationTokenRepository confirmationTokenRepository; //@AllArgsConstructor doesn't work with final

    ConfirmationTokenService(ConfirmationTokenRepository confirmationTokenRepository) {
        this.confirmationTokenRepository = confirmationTokenRepository;
    }

    void saveConfirmationToken(ConfirmationToken confirmationToken){
        confirmationTokenRepository.save(confirmationToken);
    }

    void deleteConfirmationToken(Long id) {
        confirmationTokenRepository.deleteById(id);
    }

    Optional<ConfirmationToken> findConfirmationTokenByToken(String token) {
        return confirmationTokenRepository.findConfirmationTokenByConfirmationToken(token);
    }
}
