package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Size(min = 2,message = "Course Name Too Short")
    @NotNull(message = "Course Name required")
    private String course_name;

    @Size(min = 2,message = "Course Description Too Short")
    @NotNull(message = "Course Description required")
    private String course_desc;

    @Min(value = 1,message = "Course Must Have Minimum 1 Credit")
    @NotNull(message = "Course Credit Required")
    private int course_credit;

    @Id
    @SequenceGenerator(name="courseSequence",sequenceName = "courseSequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "courseSequence")
    @Column(name = "course_id")
    private int course_id;

    @OneToMany(mappedBy = "course")
    Set<Student_Course> stcuc;

    @OneToMany(mappedBy = "course")
    Set<Teacher_Course> tecuc;


}
