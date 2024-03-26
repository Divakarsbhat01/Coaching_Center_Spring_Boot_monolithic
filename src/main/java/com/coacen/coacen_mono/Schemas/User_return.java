package com.coacen.coacen_mono.Schemas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User_return
{
    String username;
    String role;
    int user_id;
}
