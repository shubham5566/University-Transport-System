package com.transport.university.universitytransportsystem.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;

@Service
public class JWTUtility {

    private String SECRET_KEY = "mysecretkey-is-very-long-and-it-has-very-good-length";

    private static final long DURATION = 5 * 3600 * 1000;

    // ✅ Generate signing key
    private Key getSigningKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    // ✅ Extract all claims
    private Claims extractAllClaims(String token) {
        if (token == null) return null;

        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSigningKey()) // ✅ FIXED
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            System.out.println("JWT Error: " + e.getMessage());
            return null;
        }
    }

    public String extractUserName(String token) {
        Claims claims = extractAllClaims(token);
        return claims != null ? claims.getSubject() : null;
    }

    public Date extractExpirationDate(String token) {
        Claims claims = extractAllClaims(token);
        return claims != null ? claims.getExpiration() : null;
    }

    private Boolean isTokenExpired(String token) {
        Date expiry = extractExpirationDate(token);
        return expiry != null && expiry.before(new Date());
    }

    public Boolean validateTokenByUserDetails(String token, UserDetails userDetails) {
        final String userName = extractUserName(token);
        return (userName != null &&
                userName.equals(userDetails.getUsername()) &&
                !isTokenExpired(token));
    }

    // ✅ Generate token (FIXED)
    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + DURATION))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256) // ✅ FIXED
                .compact();
    }
}