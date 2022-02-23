package com.jayklef.brevit.controller;

import com.jayklef.brevit.event.RegistrationCompleteEvent;
import com.jayklef.brevit.model.RegistrationModel;
import com.jayklef.brevit.model.User;
import com.jayklef.brevit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationModel registrationModel, final HttpServletRequest request){
        User user = userService.registerUser(registrationModel);
        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));
        return "User Saved successfully";
    }

    @GetMapping("/verifyRegistration")
    public String verifyRegistrationToken(@RequestParam("token") String token){
        String result = userService.validateVerficationToken(token);

        if (result.equalsIgnoreCase("valid")){
            return "User verified successfully";
        }
        return "Bad User request";
    }

    private String applicationUrl(HttpServletRequest request) {

        return "http://" +
                request.getServerName() +
                ":" +
                request.getServerPort() +
                request.getContextPath();
    }

}
