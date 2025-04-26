package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
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
    @SequenceGenerator(name="studentCSequence",sequenceName = "studentCSequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "studentCSequence")
    private int scID;

    @Min(value = 1,message = "Student Id should not be less than 0")
    @NotNull(message = "Student ID Required")
    private int studentId;

    @Min(value = 1,message = "Course Id should not be less than 0")
    @NotNull(message = "Course ID Required")
    private int courseId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "studentId",insertable = false,updatable = false,referencedColumnName = "student_id")
    private Student student;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId",insertable = false,updatable = false,referencedColumnName = "course_id")
    private Course course;
}
