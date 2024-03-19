package com.coacen.coacen_mono.Serviceimplementation;

import com.coacen.coacen_mono.Entity.User_Details;
import com.coacen.coacen_mono.Entity.User_Id_Counter;
import com.coacen.coacen_mono.Repository.User_Credentials_Repository;
import com.coacen.coacen_mono.Repository.User_Id_Counter_Repository;
import com.coacen.coacen_mono.Service.User_Details_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class User_Details_si implements User_Details_Service {
    @Autowired
    User_Credentials_Repository udr;

    @Autowired
    User_Id_Counter_Repository uicr;

    @Override
    public User_Details save_user_details(User_Details udrb) {
        User_Id_Counter ab=uicr.findById(1).get();
        int future_id=(ab.getUser_id_counter())+1;
        ab.setUser_id_counter(future_id);
        uicr.save(ab);
        udrb.setUserId(future_id);
        udr.save(udrb);
        return udrb;
    }

    @Override
    public User_Details userDetails_updateService(int userId, User_Details udrb) throws Exception {
        Boolean check = udr.findById(userId).isPresent();
        if (check == Boolean.TRUE) {
            User_Details x = udr.findById(userId).get();
            x.setUserName(udrb.getUserName());
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
    public List<User_Details> getallUsers() {
        return udr.findAll();
    }

    @Override
    public User_Details getUsers_byId(int userId) throws Exception {
        Boolean check = udr.findById(userId).isPresent();
        if (check == Boolean.TRUE)
        {
            User_Details x = udr.findById(userId).get();
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
}
