package com.foodify.auth_service.security;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    private final String SECRET_KEY = "foodify_secret_foodify_secret_12345";

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    private final long EXPIRATION_TIME = 1000 * 60 * 60;

    public String generateToken(String email){
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+ EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractEmail(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validToken(String token){
     try {
         Jwts.parserBuilder()
                 .setSigningKey(key)
                 .build()
                 .parseClaimsJws(token);
         return true;
     }
     catch (JwtException | IllegalArgumentException e){
         return false;
     }
    }

}
