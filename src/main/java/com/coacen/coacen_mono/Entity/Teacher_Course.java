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
@Table(name = "TEACHER_COURSE")
public class Teacher_Course
{
    @Id
    @SequenceGenerator(name="teacherCSequence",sequenceName = "teacherCSequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "teacherCSequence")
    private int tcID;

    @Min(value = 1,message = "Teacher Id should not be less than 0")
    @NotNull(message = "Teacher ID Required")
    private int teacherId;

    @Min(value = 1,message = "Course Id should not be less than 0")
    @NotNull(message = "Course ID Required")
    private int courseId;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "teacherId",insertable = false,updatable = false,referencedColumnName = "teacher_id")
    private Teacher teacher;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "courseId",insertable = false,updatable = false,referencedColumnName = "course_id")
    private Course course;
}
