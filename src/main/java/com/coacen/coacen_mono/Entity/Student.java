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
    private int parent_id;

    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinColumn(name = "parent_id",insertable = false,updatable = false,referencedColumnName = "parent_id")
    private Parent parent;

    @OneToMany(mappedBy = "student")
    Set<Student_Course> stcus;

}
