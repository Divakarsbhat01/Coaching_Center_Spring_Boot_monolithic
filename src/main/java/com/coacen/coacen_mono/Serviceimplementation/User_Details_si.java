package com.coacen.coacen_mono.Serviceimplementation;

import com.coacen.coacen_mono.Configuration.JwtService;
import com.coacen.coacen_mono.Entity.User;
import com.coacen.coacen_mono.Entity.User_Id_Counter;
import com.coacen.coacen_mono.Error_Control.Exceptions.userNotFoundException;
import com.coacen.coacen_mono.Repository.User_Credentials_Repository;
import com.coacen.coacen_mono.Repository.User_Id_Counter_Repository;
import com.coacen.coacen_mono.Schemas.User_return;
import com.coacen.coacen_mono.Schemas.user_login_input;
import com.coacen.coacen_mono.Service.User_Details_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class User_Details_si implements User_Details_Service {
    @Autowired
    User_Credentials_Repository udr;

    @Autowired
    User_Id_Counter_Repository uicr;

    @Autowired
    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Autowired
    JwtService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public User_return save_user_details(User udrb) {
        User_Id_Counter ab=uicr.findById(1).get();
        int future_id=(ab.getUser_id_counter())+1;
        ab.setUser_id_counter(future_id);
        uicr.save(ab);
        udrb.setUserId(future_id);
        udrb.setUserPassword(passwordEncoder.encode(udrb.getPassword()));
        udr.save(udrb);
        User_return ur=new User_return();
        ur.setRole(String.valueOf(udrb.getUserRole()));
        ur.setUsername(udrb.getUsername());
        ur.setUser_id(udrb.getUserId());
        return ur;
    }

    @Override
    public User userDetails_updateService(int userId, User udrb) throws Exception
    {
        Boolean check = udr.findById(userId).isPresent();
        if (check == Boolean.TRUE)
        {
            User x = udr.findById(userId).get();
            x.setUserName(udrb.getUsername());
            x.setUserPassword(udrb.getUserPassword());
            x.setUserRole(udrb.getUserRole());
            udr.save(x);
            return x;
        } else if (check == Boolean.FALSE)
        {
            throw new userNotFoundException("UserId not Found");
        }
        return udrb;
    }

    @Override
    public List<User> getallUsers()
    {
        return udr.findAll();
    }

    @Override
    public User getUsers_byId(int userId) throws Exception
    {
        Boolean check = udr.findById(userId).isPresent();
        if (check == Boolean.TRUE)
        {
            User x = udr.findById(userId).get();
            return x;
        }
        else
        {
            throw new userNotFoundException("UserId not Found");
        }
    }

    @Override
    public Boolean delete_user(int userId) throws userNotFoundException {
        Boolean x=udr.findById(userId).isPresent();
        if (x==Boolean.TRUE)
        {
            udr.deleteById(userId);
            return Boolean.TRUE;
        }
        else
        {
            throw new userNotFoundException("UserId not Found");
        }

    }

    @Override
    public String userlogin(user_login_input userLogibObj)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLogibObj.getUsername(),userLogibObj.getPassword()
        ));
/*
authenticate the user using authentication manager it redirects internally
to authentication provider which obtains USerDetails through which it access
JPA repository gets username and password and authenticates it with user
provided authentication and password
*/
        User x=udr.findByuserName(userLogibObj.getUsername());
//here map the login details with USer object
        String token= jwtService.generateToken(x);
// pass user object to method in jwt service to generate token
        return token;
//return token to controller
    }
}
