package com.coacen.coacen_mono.Configuration;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.*;
import java.util.function.Function;

/*
JWT token is a compact url representation in claims
3 parts header payload signature
header: algorithm, type
payload: claims statements about entity and additional data
signature: signed secret key
3 types claims : registered claims Recommended (issuer, subject, expiration),public claims, private claims
 */
@Service
public class JwtService
{
    private static final String SECRET_KEY="C67CCBF37AAAB6D61D1D52E6BD265B189FA05744DDFDD99A5510833F11FC1482";

    //extract all claims
    private Claims extractAllClaims(String token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
    //extract single claim that we pass
    public <T> T extractClaim(String token, Function<Claims,T>claimsResolver)
    {
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public String extractUSername(String token)
    {
        return extractClaim(token,Claims::getSubject);
    }

    private Key getSignInKey()
    {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    //generate token
    public String generateToken(Map<String, Object>extraClaims, UserDetails userDetails)
    {
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    //if only username is there no extra things like usn,exp,issued
    public String generateToken(UserDetails userDetails)
    {
        return generateToken(new HashMap<>(),userDetails);
    }

    //validate the token
    public Boolean isTokenValid(String token,UserDetails userDetails)
    {
        final String username_extracted=extractUSername(token);
        return (username_extracted.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token)
    {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token)
    {
        return extractClaim(token,Claims::getExpiration);
    }
}
