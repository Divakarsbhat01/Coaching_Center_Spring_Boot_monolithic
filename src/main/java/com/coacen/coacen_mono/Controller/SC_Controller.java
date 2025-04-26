package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Entity.Student;
import com.coacen.coacen_mono.Entity.Student_Course;
import com.coacen.coacen_mono.Schemas.Student_return;
import com.coacen.coacen_mono.Serviceimplementation.SC_si;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name="Student Course",description = "All Operations related to student and their courses")
@RequestMapping("/student_course")
@RestController
public class SC_Controller
{
    @Autowired
    SC_si scSi;

    @Tag(name="Student Course",description = "Get all Student with their Course Names")
    @PostMapping("/create_student_course")
    public  Student_Course create_student_course(@RequestBody Student_Course student_course)
    {
        return scSi.create_student_course(student_course);
    }
}
