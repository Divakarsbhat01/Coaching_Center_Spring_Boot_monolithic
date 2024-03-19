package com.coacen.coacen_mono.Repository;

import com.coacen.coacen_mono.Entity.User_Details;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface User_Credentials_Repository extends MongoRepository<User_Details,Integer>
{

}
