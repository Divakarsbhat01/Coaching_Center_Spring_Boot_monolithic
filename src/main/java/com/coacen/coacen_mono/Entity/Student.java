package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
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
    private String student_first_name;
    private String student_last_name;
    private String email_id;
    private int student_age;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "parent_id",referencedColumnName = "parent_id")
    private Parent parent;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="Student_Course",
    joinColumns = @JoinColumn(name="student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;
}
