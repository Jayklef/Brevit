package com.jayklef.brevit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationModel {

    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;
    private String matchingPassword;
}
