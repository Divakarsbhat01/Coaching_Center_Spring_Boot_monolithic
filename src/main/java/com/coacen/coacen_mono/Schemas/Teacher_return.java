package com.coacen.coacen_mono.Schemas;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher_return
{
    private String teacher_first_name;
    private String teacher_last_name;
    private String teacher_email;
    private int teacher_id;
}
