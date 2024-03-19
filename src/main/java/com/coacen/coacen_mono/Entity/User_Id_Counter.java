package com.coacen.coacen_mono.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "user_id_counter")
public class User_Id_Counter
{
    @Id
    private int userId;
    private int user_id_counter;
    private String counter_name;
}
