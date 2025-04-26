package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Size(min = 2,message = "Teacher First Name Too Short")
    @NotNull(message = "Teacher First Name Required")
    private String teacher_first_name;

    @Size(min = 2,message = "Teacher Last Name Too Short")
    @NotNull(message = "Teacher Last Name Required")
    private String teacher_last_name;

    @NotNull(message = "Teacher Email Required")
    @Email(message = "Teacher Email Not Acceptable")
    private String teacher_email;

    @Id
    @SequenceGenerator(name="teacherSequence",sequenceName = "teacherSequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacherSequence")
    private int teacher_id;

    @OneToMany(mappedBy = "teacher")
    Set<Teacher_Course> tecut;

}
