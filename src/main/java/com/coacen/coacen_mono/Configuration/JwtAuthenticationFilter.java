package com.coacen.coacen_mono.Configuration;

import com.coacen.coacen_mono.Repository.User_Credentials_Repository;
import com.coacen.coacen_mono.Serviceimplementation.User_Details_si;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
@Component
@RequiredArgsConstructor
/*
This filter is used to verify and implement JWt Authentication as this filter has to
run once every request it extend sto once per request filter and implements its methods
the request, response and filter chain has to be not null
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter
{
    private final JwtService jwtService;

    @Autowired
    private final User_Credentials_Repository ucr;
    @Override
    protected void doFilterInternal(
            @NotNull  HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain) throws ServletException, IOException
    {
        /*
        1.Jwt token is passed in header first i extract header, and authorization part
        2.check if authorization is null or dosent start with bearer then filter this
        request and response and return
         */
        final String authHeader=request.getHeader("Authorization");
        final String jwt;
        final String extracted_username;
        if (authHeader==null|| !authHeader.startsWith("Bearer"))
        {
            filterChain.doFilter(request,response);
            return;
        }
        jwt=authHeader.substring(7);
        extracted_username=jwtService.extractUSername(jwt);
        // if username is not null and the user is not authenticated in securrity Context
        //get all user details through username and put it into security context
        if(extracted_username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
            UserDetails userDetails=ucr.findByuserName(extracted_username);
            if(jwtService.isTokenValid(jwt,userDetails))
            {
                UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(
                        userDetails,null,userDetails.getAuthorities()
                ) ;
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request,response);
    }
}
