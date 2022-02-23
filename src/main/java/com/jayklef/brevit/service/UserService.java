package com.jayklef.brevit.service;

import com.jayklef.brevit.model.RegistrationModel;
import com.jayklef.brevit.model.User;

public interface UserService {

    User registerUser(RegistrationModel registrationModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerficationToken(String token);

}
