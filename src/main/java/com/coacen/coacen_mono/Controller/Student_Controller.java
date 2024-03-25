package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Entity.Student;
import com.coacen.coacen_mono.Schemas.Student_return;
import com.coacen.coacen_mono.Service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Student_return create_student(@RequestBody Student student)
    {
        return studentService.create_student(student);
    }

    @GetMapping("/all_students")
    public List<Student> get_all_students()
    {
        return studentService.get_all_students();
    }
    @GetMapping("/students_by_id/{id}")
    public Optional<Student> get_all_students(@PathVariable("id") int student_id)
    {

        return studentService.get_student_byId(student_id);
    }
    @PutMapping("/update_student/{id}")
    public Student update_student_by_id(@PathVariable ("id") int student_id,@RequestBody Student student) throws Exception {
        return studentService.update_student_by_id(student_id,student);
    }
    @DeleteMapping("/delete_student/{id}")
    public HashMap<String,String> delete_student(@PathVariable ("id") int student_id)
    {
        Boolean x=studentService.delete_student_by_id(student_id);
        if (x==Boolean.TRUE)
        {
            HashMap<String,String>ab=new HashMap<String,String>();
            ab.put("Message","Delete SUccess");
            return ab;
        }
        else
        {
            HashMap<String,String>ab=new HashMap<String,String>();
            ab.put("Message","Delete UnSuccessful");
            return ab;
        }
    }
}
