package com.coacen.coacen_mono.Service;

import com.coacen.coacen_mono.Entity.User_Details;
import com.coacen.coacen_mono.Entity.User_Id_Counter;
import com.coacen.coacen_mono.Schemas.user_login_input;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface User_Details_Service {
    User_Details save_user_details(User_Details udrb);

    User_Details userDetails_updateService(int userId, User_Details udrb) throws Exception;

    List<User_Details> getallUsers();

    User_Details getUsers_byId(int userId) throws Exception;

    Boolean delete_user(int userId);

    Boolean userlogin(user_login_input userLogibObj);
}
