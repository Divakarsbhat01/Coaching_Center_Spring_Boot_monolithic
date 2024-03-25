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
1. JWT token is a compact url representation in claims
2. it contains 3 parts: header, payload, signature
3. header contains: algorithm, type
4. payload contains: claims statements about entity and additional data
5. signature contains: signed secret key
3 types claims : registered claims Recommended (issuer, subject, expiration),public claims, private claims
 */
@Service
public class JwtService
{
    private static final String SECRET_KEY="C67CCBF37AAAB6D61D1D52E6BD265B189FA05744DDFDD99A5510833F11FC1482";
// Define Secret key which is a hex 256 bit key
    private Claims extractAllClaims(String token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
/*
This Method is USed to extract all claims from the token
*/
    public <T> T extractClaim(String token, Function<Claims,T>claimsResolver)
    {
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
//This Method is used to Extract a Single parameter we want based on the extracted claims

    public String extractUSername(String token)
    {
        return extractClaim(token,Claims::getSubject);
    }
//This Method makes use of extract single claim method to extract specifically username
    private Key getSignInKey()
    {
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
//This Method generates the signed key required to extract all claims based on secret key

    public String generateToken(Map<String, Object>extraClaims, UserDetails userDetails)
    {
        return Jwts.builder().setClaims(extraClaims).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*24))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }
//This Method is used to generate token using all details
    public String generateToken(UserDetails userDetails)
    {
        return generateToken(new HashMap<>(),userDetails);
    }
//This Method is used to generate token using only the username,expiration time etc

    public Boolean isTokenValid(String token,UserDetails userDetails)
    {
        final String username_extracted=extractUSername(token);
        return (username_extracted.equals(userDetails.getUsername())) && !isTokenExpired(token);
    }
//validate the token
    private boolean isTokenExpired(String token)
    {
        return extractExpiration(token).before(new Date());
    }
//This is used to calculate if token has not expired before current time returns true or false

    private Date extractExpiration(String token)
    {
        return extractClaim(token,Claims::getExpiration);
    }
// get the expiration date of the token
}
