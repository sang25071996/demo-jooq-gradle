package com.demo.config;

import com.demo.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class MyAuthenticationSuccessListener implements ApplicationListener<AuthenticationSuccessEvent> {
    private final UserService userService;

    public MyAuthenticationSuccessListener(UserService userService) {
        this.userService = userService;
    }
    @Override
    public void onApplicationEvent(AuthenticationSuccessEvent event) {
        log.info("even login {}", event.getAuthentication().isAuthenticated());
    }
}
