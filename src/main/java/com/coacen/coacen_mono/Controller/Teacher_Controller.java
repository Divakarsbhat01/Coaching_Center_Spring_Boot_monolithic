package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Error_Control.Exceptions.teacherNotFoundException;
import com.coacen.coacen_mono.Schemas.Teacher_return;
import com.coacen.coacen_mono.Service.Teacher_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.coacen.coacen_mono.Entity.Teacher;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class Teacher_Controller
{
    @Autowired
    Teacher_Service teacherService;
    @PostMapping("/create_teacher")
    public ResponseEntity<Teacher_return> create_teacher(@RequestBody Teacher teacher)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(teacherService.create_teacher(teacher));
    }

    @GetMapping("/all_teachers")
    public ResponseEntity<List<Teacher>> get_all_teachers()
    {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.get_all_teachers());
    }
    @GetMapping("/teachers_by_id/{id}")
    public ResponseEntity<Optional<Teacher>> get_all_teachers(@PathVariable("id") int teacher_id) throws teacherNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(teacherService.get_teacher_byId(teacher_id));
    }
    @PutMapping("/update_teacher/{id}")
    public ResponseEntity<Teacher_return> update_teacher_by_id(@PathVariable ("id") int teacher_id, @RequestBody Teacher teacher) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.update_teacher_by_id(teacher_id,teacher));
    }
    @DeleteMapping("/delete_teacher/{id}")
    public ResponseEntity<HashMap<String,String>> delete_teacher(@PathVariable ("id") int teacher_id)
    {
        Boolean x=teacherService.delete_teacher_by_id(teacher_id);
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
