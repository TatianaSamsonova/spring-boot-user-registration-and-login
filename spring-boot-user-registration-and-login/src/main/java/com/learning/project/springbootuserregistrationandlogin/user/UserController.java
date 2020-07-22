package com.learning.project.springbootuserregistrationandlogin.user;

import com.learning.project.springbootuserregistrationandlogin.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

/**
 * @author TatianaSamsonova
 * @created 22/07/2020 - 11:43 AM
 * @project spring-boot-user-registration-and-login
 */

@Controller
@AllArgsConstructor
public class UserController {

    private UserService userService;

    private ConfirmationTokenService confirmationTokenService;

    @GetMapping("/sign-in")
    String signIn(){
        return "sign-in";
    }

    @GetMapping("/sign-up")
    String signUp(){
        return "sign-up";
    }

    @PostMapping("/sign-up")
    String signUp(User user){
        userService.signUpUser(user);
        return "redirect:/sign-in";
    }

    @GetMapping("/confirm")
    String confirmMail(@RequestParam("token") String token){

        Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);
        optionalConfirmationToken.ifPresent(userService::confirmUser);

        return "/sign-in";
    }
}
