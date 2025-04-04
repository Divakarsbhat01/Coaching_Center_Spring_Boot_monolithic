package com.coacen.coacen_mono.Service;

import com.coacen.coacen_mono.Entity.Student_Course;
import com.coacen.coacen_mono.Entity.Teacher_Course;
import org.springframework.stereotype.Service;

@Service
public interface Teacher_Course_Service
{
    public Teacher_Course create_teacher_course(Teacher_Course teacherCourse);
}
