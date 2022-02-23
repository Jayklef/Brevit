package com.jayklef.brevit.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class VerificationToken {

    private static final int EXPIRATION_TIME = 15;
    @Id
    private Long id;
    private String token;
    private Date expiresAt;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",
                nullable = false,
                foreignKey = @ForeignKey(name = "FK_USER_TOKEN_VERIFY"))
    private User user;


    public VerificationToken(User user, String token){
        super();
        this.user = user;
        this.token = token;
        this.expiresAt = calculateExpirationTime(EXPIRATION_TIME);
    }

    public VerificationToken(String token){
        super();
        this.token = token;
        this.expiresAt = calculateExpirationTime(EXPIRATION_TIME);
    }

    private Date calculateExpirationTime(int expirationTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.MINUTE, expirationTime);
        return new Date(calendar.getTime().getTime());
    }
}
