package com.spring.crud.security;

import com.spring.crud.domain.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtService {

    private static final String SECRET_KEY = "7";

    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getEmail())
                .claim("role", user.getRole())
                .setIssuer(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) //15 min
                .signWith(getSingKey(), SignatureAlgorithm.HS256)
                .compact();
    }
}
