package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name="PARENT")
public class Parent
{
    @Size(min = 2,message = "Parent First Name Too Short")
    @NotNull(message = "Parent First Name cannot be null")
    private String parent_first_name;

    @Size(min = 2,message = "Parent Last Name Too Short")
    @NotNull(message = "Parent Last Name cannot be null")
    private String parent_last_name;

    @NotNull(message = "Parent Email cannot be null")
    @Email(message = "Parent Email Not Acceptable")
    private String parent_email;

    @Size(min = 10,max = 10, message = "Phone Number Must have 10 Numbers")
    @NotNull(message = "Parent Mobile cannot be null")
    private String parent_mobile;

    @Id
    @SequenceGenerator(name="parentSequence",sequenceName = "parentSequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "parentSequence")
    @Column(name = "parent_id")
    private int parent_id;

    @OneToMany(mappedBy = "parent")
    Set<Student> student;
}
