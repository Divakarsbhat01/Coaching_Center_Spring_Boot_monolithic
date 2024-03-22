package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
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
    private String course_name;
    private String course_desc;
    private int course_credit;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int course_id;

    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private Set<Student>students;

    @ManyToMany(mappedBy = "courses",cascade = CascadeType.ALL)
    private Set<Teacher>teachers;
}