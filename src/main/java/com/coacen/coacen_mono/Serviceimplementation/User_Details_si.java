package com.coacen.coacen_mono.Serviceimplementation;

import com.coacen.coacen_mono.Configuration.JwtService;
import com.coacen.coacen_mono.Entity.User;
import com.coacen.coacen_mono.Entity.User_Id_Counter;
import com.coacen.coacen_mono.Repository.User_Credentials_Repository;
import com.coacen.coacen_mono.Repository.User_Id_Counter_Repository;
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
    public User save_user_details(User udrb) {
        User_Id_Counter ab=uicr.findById(1).get();
        int future_id=(ab.getUser_id_counter())+1;
        ab.setUser_id_counter(future_id);
        uicr.save(ab);
        udrb.setUserId(future_id);
        udrb.setUserPassword(passwordEncoder.encode(udrb.getPassword()));
        udr.save(udrb);
        return udrb;
    }

    @Override
    public User userDetails_updateService(int userId, User udrb) throws Exception {
        Boolean check = udr.findById(userId).isPresent();
        if (check == Boolean.TRUE) {
            User x = udr.findById(userId).get();
            x.setUserName(udrb.getUsername());
            x.setUserPassword(udrb.getUserPassword());
            x.setUserRole(udrb.getUserRole());
            udr.save(x);
            return x;
        } else if (check == Boolean.FALSE) {
            throw new Exception("The Requested id is not Available");
        }
        return udrb;
    }

    @Override
    public List<User> getallUsers() {
        return udr.findAll();
    }

    @Override
    public User getUsers_byId(int userId) throws Exception {
        Boolean check = udr.findById(userId).isPresent();
        if (check == Boolean.TRUE)
        {
            User x = udr.findById(userId).get();
            return x;
        } else if (check == Boolean.FALSE)
        {
            throw new Exception("The Requested id is not Available");
        }
        return null;
    }

    @Override
    public Boolean delete_user(int userId) {
        Boolean x=udr.findById(userId).isPresent();
        if (x==Boolean.TRUE)
        {
            udr.deleteById(userId);
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public String userlogin(user_login_input userLogibObj)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userLogibObj.getUsername(),userLogibObj.getPassword()
        ));
        User x=udr.findByuserName(userLogibObj.getUsername());
        String token= jwtService.generateToken(x);
        return token;
    }


}
