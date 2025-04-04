package com.coacen.coacen_mono.Serviceimplementation;

import com.coacen.coacen_mono.Entity.Teacher_Course;
import com.coacen.coacen_mono.Repository.Student_Course_Repository;
import com.coacen.coacen_mono.Repository.Teacher_Course_Repository;
import com.coacen.coacen_mono.Service.Teacher_Course_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TC_si implements Teacher_Course_Service
{

    @Autowired
    Teacher_Course_Repository tcr;

    public Teacher_Course create_teacher_course(Teacher_Course teacherCourse)
    {
        return tcr.save(teacherCourse);
    }
}
