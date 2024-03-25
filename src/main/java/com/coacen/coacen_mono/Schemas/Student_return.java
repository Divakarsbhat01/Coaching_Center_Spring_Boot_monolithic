package com.coacen.coacen_mono.Schemas;

import com.coacen.coacen_mono.Entity.Course;
import com.coacen.coacen_mono.Entity.Parent;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student_return
{
        private int student_id;
        private String student_first_name;
        private String student_last_name;
        private String email_id;
        private int student_age;
        private int parent_id;
}
