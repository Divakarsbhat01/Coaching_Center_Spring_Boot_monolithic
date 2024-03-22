package com.coacen.coacen_mono.Repository;

import com.coacen.coacen_mono.Entity.User_Id_Counter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface User_Id_Counter_Repository extends MongoRepository<User_Id_Counter,Integer>
{

}
