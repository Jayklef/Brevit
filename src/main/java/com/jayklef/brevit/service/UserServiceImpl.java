package com.jayklef.brevit.service;

import com.jayklef.brevit.model.User;
import com.jayklef.brevit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return null;
    }
}
