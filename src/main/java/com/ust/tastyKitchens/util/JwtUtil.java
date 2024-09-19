package com.ust.tastyKitchens.util;// Adjust package name as necessary

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.JwtParserBuilder;

import java.security.SignatureException;

public class JwtUtil {

    private String secretKey = "fjrrfrhyfugrfgrdhflidjfildshrfkgjhtghtfjkghskjdhfndskjdsfdsf"; // Replace with your actual secret key

    public Claims parseToken(String token) {
        JwtParser parser = (JwtParser) Jwts.parser().setSigningKey(secretKey);
        return parser.parseClaimsJws(token).getBody();
    }
}
