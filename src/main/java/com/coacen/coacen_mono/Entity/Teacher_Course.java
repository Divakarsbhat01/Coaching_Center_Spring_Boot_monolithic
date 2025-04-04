package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TEACHER_COURSE")
public class Teacher_Course
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int tcID;
    private int teacherId;
    private int courseId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherId",insertable = false,updatable = false,referencedColumnName = "teacher_id")
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId",insertable = false,updatable = false,referencedColumnName = "course_id")
    private Course course;
}
