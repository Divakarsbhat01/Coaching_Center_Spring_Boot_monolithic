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
@Table(name="PARENT")
public class Parent
{
    @NotNull(message = "Parent First Name cannot be null")
    @Pattern(regexp ="/^[a-zA-Z ]*$/",message = "Parent First NAme cannot contain numbers")
    private String parent_first_name;

    @NotNull(message = "Parent Last Name cannot be null")
    @Pattern(regexp ="/^[a-zA-Z ]*$/",message = "Parent Last NAme cannot contain numbers")
    private String parent_last_name;

    @NotNull(message = "Parent Email cannot be null")
    @Email(message = "Parent Email Not Acceptable")
    private String parent_email;

    @NotNull(message = "Parent Mobile cannot be null")
    private String parent_mobile;

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int parent_id;

    @OneToMany(mappedBy = "parent")
    Set<Student> student;
}
