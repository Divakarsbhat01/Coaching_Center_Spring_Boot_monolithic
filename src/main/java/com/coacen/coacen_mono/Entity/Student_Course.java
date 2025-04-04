package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "STUDENT_COURSE")
public class Student_Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int scID;
    private int studentId;
    private int courseId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId",insertable = false,updatable = false,referencedColumnName = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId",insertable = false,updatable = false,referencedColumnName = "course_id")
    private Course course;
}
