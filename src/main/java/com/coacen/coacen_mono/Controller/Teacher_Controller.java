package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Schemas.Teacher_return;
import com.coacen.coacen_mono.Service.Teacher_Service;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Teacher_return create_teacher(@RequestBody Teacher teacher)
    {
        return teacherService.create_teacher(teacher);
    }

    @GetMapping("/all_teachers")
    public List<Teacher> get_all_teachers()
    {
        return teacherService.get_all_teachers();
    }
    @GetMapping("/teachers_by_id/{id}")
    public Optional<Teacher> get_all_teachers(@PathVariable("id") int teacher_id)
    {

        return teacherService.get_teacher_byId(teacher_id);
    }
    @PutMapping("/update_teacher/{id}")
    public Teacher update_teacher_by_id(@PathVariable ("id") int teacher_id,@RequestBody Teacher teacher) throws Exception {
        return teacherService.update_teacher_by_id(teacher_id,teacher);
    }
    @DeleteMapping("/delete_teacher/{id}")
    public HashMap<String,String> delete_teacher(@PathVariable ("id") int teacher_id)
    {
        Boolean x=teacherService.delete_teacher_by_id(teacher_id);
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
