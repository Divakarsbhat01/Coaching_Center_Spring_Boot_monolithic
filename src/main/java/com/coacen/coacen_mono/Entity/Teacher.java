package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotNull(message = "Teacher First Name Required")
    @Pattern(regexp ="/^[a-zA-Z ]*$/",message = "Teacher First Name shouldn't contain numbers")
    private String teacher_first_name;

    @NotNull(message = "Teacher Last Name Required")
    @Pattern(regexp ="/^[a-zA-Z ]*$/",message = "Teacher Last Name shouldn't contain numbers")
    private String teacher_last_name;

    @NotNull(message = "Teacher Email Required")
    @Email(message = "Teacher Email Not Acceptable")
    private String teacher_email;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int teacher_id;

    @OneToMany(mappedBy = "teacher")
    Set<Teacher_Course> tecut;

}
