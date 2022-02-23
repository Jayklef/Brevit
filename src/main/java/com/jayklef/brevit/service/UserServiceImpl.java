package com.jayklef.brevit.service;

import com.jayklef.brevit.model.RegistrationModel;
import com.jayklef.brevit.model.User;
import com.jayklef.brevit.model.VerificationToken;
import com.jayklef.brevit.repository.UserRepository;
import com.jayklef.brevit.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Calendar;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private VerificationTokenRepository verificationTokenRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User registerUser(RegistrationModel registrationModel) {

        User user = new User();
        user.setFirstname(registrationModel.getFirstname());
        user.setLastname(registrationModel.getLastname());
        user.setEmail(registrationModel.getEmail());
        user.setUsername(registrationModel.getUsername());
        user.setPassword(passwordEncoder.encode(registrationModel.getPassword()));

        userRepository.save(user);

        return user;
    }

    @Override
    public void saveVerificationTokenForUser(String token, User user) {
        VerificationToken verificationToken =
                new VerificationToken(user, token);

        verificationTokenRepository.save(verificationToken);
    }

    @Override
    public String validateVerficationToken(String token) {

        VerificationToken verificationToken = userRepository.findByToken(token);

        if (verificationToken == null){
            return "invalid token";
        }

        User user = verificationToken.getUser();
        Calendar cal = Calendar.getInstance();

        if ((verificationToken.getExpiresAt().getTime()) - cal.getTime().getTime() <= 0){
            verificationTokenRepository.delete(verificationToken);
            return "expired";
        }

        user.setEnabled(true);
        userRepository.save(user);
        return "valid";
    }

}
