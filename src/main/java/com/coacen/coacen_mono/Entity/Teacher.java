package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TEACHER")
public class Teacher
{
    private String teacher_first_name;
    private String teacher_last_name;
    private String teacher_email;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int teacher_id;

    @OneToMany(mappedBy = "teacher")
    Set<Teacher_Course> tecut;

}
