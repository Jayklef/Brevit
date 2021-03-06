package com.jayklef.brevit.repository;

import com.jayklef.brevit.model.User;
import com.jayklef.brevit.model.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    VerificationToken findByToken(String token);

    User getUserByUsername(String email);
}
