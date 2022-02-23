package com.jayklef.brevit.event;

import com.jayklef.brevit.model.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;

    private String applicationUrl;

    public RegistrationCompleteEvent(User user, String applicationUrl) {
        super(user);
        this.user = user;
        this.applicationUrl = applicationUrl;
    }
}
