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
This custom filter is used to verify as well as implement JWT Authentication
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter
//This filter runs once per every request therefore once per request filter
{
    private final JwtService jwtService;
//This is for Initializing jwt service
    @Autowired
    private final User_Credentials_Repository ucr;
//This is for initializing user credentials repository
    @Override
    protected void doFilterInternal
    (
            @NotNull  HttpServletRequest request,
            @NotNull HttpServletResponse response,
            @NotNull FilterChain filterChain
    )
            throws ServletException, IOException
    {
/*
This is a default method that has to be implemented when extending to the
once per request filter, it has three arguements request, response and filter
chain and throws exceptions
*/
        final String authHeader=request.getHeader("Authorization");
//extract the authorization part from the request's header
        final String jwt;
        final String extracted_username;
// declare 2 variables to store extracted username from token and token itself
        if (authHeader==null|| !authHeader.startsWith("Bearer"))
        {
            filterChain.doFilter(request,response);
            return;
        }
/*
1. This if block is to check if the authorizations is null and
2. even if authorization is present is it not bearer?
3. if both satisfied then put the request and response back to filterchain and return
*/
        jwt=authHeader.substring(7);
//extract the token from authroization string why 7 is "Bearer " is seven letters
        extracted_username=jwtService.extractUSername(jwt);
//extract the username from the token by passing it to a method in jwt service
        if(extracted_username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
        {
/*
1. In the if block at the top
2. if extracted username is not null and the user is not authenticated in
security Context holder
*/
            UserDetails userDetails=ucr.findByuserName(extracted_username);
            if (userDetails==null)
                {
                    throw new ServletException("The user is not registered");
                }
//check if the username exists in the registered users if not throw error
            if(jwtService.isTokenValid(jwt,userDetails))
            {
//check if the jwt token is valid if user is present
                UsernamePasswordAuthenticationToken authToken=
                        new UsernamePasswordAuthenticationToken
                                (
                                    userDetails,null,userDetails.getAuthorities()
                                ) ;
//create a new userpassword authentication token for context holder
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//build that token
                SecurityContextHolder.getContext().setAuthentication(authToken);
//get the security context and set the user name and password and now user is authenticated
            }
        }
        filterChain.doFilter(request,response);
//pass the request and response to next filter in chain
    }
}
