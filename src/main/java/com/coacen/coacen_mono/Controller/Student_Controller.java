package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Entity.Student;
import com.coacen.coacen_mono.Error_Control.Exceptions.studentNotFoundException;
import com.coacen.coacen_mono.Schemas.Student_return;
import com.coacen.coacen_mono.Service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class Student_Controller
{
    @Autowired
    Student_Service studentService;
    @PostMapping("/create_student")
    public ResponseEntity<Student_return> create_student(@RequestBody Student student)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create_student(student));
    }

    @GetMapping("/all_students")
    public ResponseEntity<List<Student>> get_all_students()
    {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.get_all_students());
    }
    @GetMapping("/students_by_id/{id}")
    public ResponseEntity<Optional<Student>> get_all_students(@PathVariable("id") int student_id) throws studentNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(studentService.get_student_byId(student_id));
    }
    @PutMapping("/update_student/{id}")
    public ResponseEntity<Student> update_student_by_id(@PathVariable ("id") int student_id,@RequestBody Student student) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.update_student_by_id(student_id,student));
    }
    @DeleteMapping("/delete_student/{id}")
    public ResponseEntity<HashMap<String,String>> delete_student(@PathVariable ("id") int student_id)
    {
        Boolean x=studentService.delete_student_by_id(student_id);
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
