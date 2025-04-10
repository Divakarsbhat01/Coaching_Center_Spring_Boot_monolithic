package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="COURSE")
public class Course
{
    @NotNull(message = "Course Name required")
    @Pattern(regexp ="/^[a-zA-Z ]*$/",message = "Course Name Shouldn't contain numbers")
    private String course_name;

    @NotNull(message = "Course Description required")
    @Pattern(regexp ="/^[a-zA-Z ]*$/",message = "Course Name Shouldn't contain numbers")
    private String course_desc;

    @NotNull(message = "Course Credit Required")
    private int course_credit;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int course_id;

    @OneToMany(mappedBy = "course")
    Set<Student_Course> stcuc;

    @OneToMany(mappedBy = "course")
    Set<Teacher_Course> tecuc;


}
