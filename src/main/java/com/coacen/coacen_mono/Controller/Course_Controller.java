package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Entity.Course;
import com.coacen.coacen_mono.Error_Control.Exceptions.courseNotFoundException;
import com.coacen.coacen_mono.Schemas.Course_Return;
import com.coacen.coacen_mono.Service.Course_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class Course_Controller
{
    @Autowired
    Course_Service courseService;
    @PostMapping("/create_course")
    public ResponseEntity<Course_Return> create_course(@RequestBody Course course)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseService.create_course(course));
    }

    @GetMapping("/all_courses")
    public ResponseEntity<List<Course>> get_all_courses()
    {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.get_all_courses());
    }
    @GetMapping("/courses_by_id/{id}")
    public ResponseEntity<Optional<Course>> get_all_courses(@PathVariable("id") int course_id) throws courseNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(courseService.get_course_byId(course_id));
    }
    @PutMapping("/update_course/{id}")
    public ResponseEntity<Course_Return> update_course_by_id(@PathVariable ("id") int course_id, @RequestBody Course course) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(courseService.update_course_by_id(course_id,course));
    }
    @DeleteMapping("/delete_course/{id}")
    public ResponseEntity<HashMap<String,String>> delete_course(@PathVariable ("id") int course_id)
    {
        Boolean x=courseService.delete_parent_by_id(course_id);
        if (x==Boolean.TRUE)
        {
            HashMap<String,String>ab=new HashMap<String,String>();
            ab.put("Message","Delete SUccess");
            return ResponseEntity.status(HttpStatus.OK).body(ab);
        }
        else
        {
            HashMap<String,String>ab=new HashMap<String,String>();
            ab.put("Message","Delete UnSuccessful");
            return ResponseEntity.status(HttpStatus.OK).body(ab);
        }
    }
}
