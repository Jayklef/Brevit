package com.jayklef.brevit.event;

import com.jayklef.brevit.model.User;
import com.jayklef.brevit.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
public class RegistrationCompleteEventListener implements ApplicationListener
        <RegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        //todo: create verification token for user with link

        User user = event.getUser();

        String token = UUID.randomUUID().toString();
        userService.saveVerificationTokenForUser(token, user);
        //todo: send mail to the user

        String url = event.getApplicationUrl()
                + "verifyRegistration?token="
                +token;

        log.info("Click the link to verify your registration: {}", url);
    }
}
