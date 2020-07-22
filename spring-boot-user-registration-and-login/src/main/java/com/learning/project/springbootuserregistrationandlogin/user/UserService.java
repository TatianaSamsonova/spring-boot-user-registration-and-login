package com.learning.project.springbootuserregistrationandlogin.user;

import com.learning.project.springbootuserregistrationandlogin.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.Optional;

/**
 * @author TatianaSamsonova
 * @created 22/07/2020 - 9:17 AM
 * @project spring-boot-user-registration-and-login
 */

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository; //@AllArgsConstructor doesn't work with final

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        final Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()){
            return optionalUser.get();
        } else {
            throw new UsernameNotFoundException(MessageFormat.format("User with email {0} cannot be found", email));
        }
    }
}
