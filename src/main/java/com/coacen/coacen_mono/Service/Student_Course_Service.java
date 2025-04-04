package com.coacen.coacen_mono.Service;

import com.coacen.coacen_mono.Entity.Student_Course;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface Student_Course_Service
{
    public Student_Course create_student_course(Student_Course studentCourse);
}
