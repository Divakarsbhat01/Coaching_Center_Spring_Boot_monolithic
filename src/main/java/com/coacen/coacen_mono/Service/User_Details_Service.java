package com.coacen.coacen_mono.Service;

import com.coacen.coacen_mono.Entity.User;
import com.coacen.coacen_mono.Schemas.user_login_input;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface User_Details_Service {
    User save_user_details(User udrb);

    User userDetails_updateService(int userId, User udrb) throws Exception;

    List<User> getallUsers();

    User getUsers_byId(int userId) throws Exception;

    Boolean delete_user(int userId);

    String userlogin(user_login_input userLogibObj);
}
