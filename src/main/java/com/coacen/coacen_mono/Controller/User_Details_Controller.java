package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Entity.User;
import com.coacen.coacen_mono.Schemas.User_return;
import com.coacen.coacen_mono.Schemas.user_login_input;
import com.coacen.coacen_mono.Service.User_Details_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class User_Details_Controller {
    @Autowired
    User_Details_Service uds;

    @GetMapping("/status")
    public HashMap<String, String> api_status()
    {
        HashMap<String, String> retmes = new HashMap<>();
        retmes.put("Message", "I am up and running");
        return retmes;
    }

    @PostMapping("/UserDetails_Create")
    public ResponseEntity<User_return> get_user_details(@RequestBody User udrb) {

        return ResponseEntity.status(HttpStatus.CREATED).body(uds.save_user_details(udrb));
    }

    @PostMapping("/UserDetails_Update/{id}")
    public ResponseEntity<User> update_user_details(@RequestBody User udrb, @PathVariable("id") int User_id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(uds.userDetails_updateService(User_id,udrb));
    }
    @GetMapping("/get_all_users")
    public ResponseEntity<List<User>> getting_all_users()
    {
        return ResponseEntity.status(HttpStatus.OK).body(uds.getallUsers());
    }

    @GetMapping("/get_users_byId/{id}")
    public ResponseEntity<User> getting_all_users(@PathVariable("id") int user_id) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(uds.getUsers_byId(user_id));
    }
    @DeleteMapping("/delete_user/{id}")
    public ResponseEntity<HashMap<String,String>> delete_given_user(@PathVariable("id") int user_id)throws Exception
    {
       Boolean x=uds.delete_user(user_id);
       HashMap<String,String> ab=new HashMap<>();
       if (x==Boolean.TRUE)
       {
           ab.put("Message","Success");
           return ResponseEntity.status(HttpStatus.OK).body(ab);
       }
       ab.put("Message","Id not found");
        return ResponseEntity.status(HttpStatus.OK).body(ab);
    }

    @PostMapping("/user_login")
    public HashMap<String,String> abc(@RequestBody user_login_input user_logib_obj)
    {
        String x= uds.userlogin(user_logib_obj);
        HashMap<String,String>ab=new HashMap<>();
        ab.put("token",x);
        ab.put("type","Bearer");
        return ab;
    }
}
