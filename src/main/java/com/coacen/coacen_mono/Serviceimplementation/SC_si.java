package com.coacen.coacen_mono.Serviceimplementation;

import com.coacen.coacen_mono.Entity.Student_Course;
import com.coacen.coacen_mono.Repository.Student_Course_Repository;
import com.coacen.coacen_mono.Service.Student_Course_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SC_si implements Student_Course_Service
{
    @Autowired
    Student_Course_Repository scr;

    public Student_Course create_student_course(Student_Course studentCourse)
    {
        return scr.save(studentCourse);
    }
}
