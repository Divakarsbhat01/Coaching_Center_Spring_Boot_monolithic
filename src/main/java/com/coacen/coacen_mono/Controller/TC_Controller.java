package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Entity.Student_Course;
import com.coacen.coacen_mono.Entity.Teacher_Course;
import com.coacen.coacen_mono.Serviceimplementation.SC_si;
import com.coacen.coacen_mono.Serviceimplementation.TC_si;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TC_Controller
{
    @Autowired
    TC_si tcSi;

    @PostMapping("/create_teacher_course")
    public Teacher_Course create_teacher_course(@RequestBody Teacher_Course teacher_course)
    {
        return tcSi.create_teacher_course(teacher_course);
    }
}
