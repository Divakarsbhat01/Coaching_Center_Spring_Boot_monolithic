package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="STUDENT")
public class Student
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int student_id;

    @NotNull(message = "Student First Name Required")
    @Pattern(regexp ="/^[a-zA-Z ]*$/",message = "Student First Name shoudn't contain numbers")
    private String student_first_name;

    @NotNull(message = "Student Last Name Required")
    @Pattern(regexp ="/^[a-zA-Z ]*$/",message = "Student Last Name shoudn't contain numbers")
    private String student_last_name;

    @Email(message = "Email Not Acceptable")
    @NotNull(message = "Student Email Required")
    private String email_id;

    @NotNull(message = "Student Age shouldn't be Null")
    @Min(value = 15,message = "Student Minimum Age has to be Above 15")
    @Max(value = 50,message = "Student Maximum Age has to be below 50")
    private int student_age;

    @NotNull(message = "Parent Id Shouldn't be Null")
    private int parent_id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id",insertable = false,updatable = false,referencedColumnName = "parent_id")
    private Parent parent;

    @OneToMany(mappedBy = "student")
    Set<Student_Course> stcus;

}
