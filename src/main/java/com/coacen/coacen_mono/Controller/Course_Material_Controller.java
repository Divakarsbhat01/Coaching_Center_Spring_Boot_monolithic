package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Entity.Course_Material;
import com.coacen.coacen_mono.Error_Control.Exceptions.courseMaterialNotFoundException;
import com.coacen.coacen_mono.Schemas.Course_Material_return;
import com.coacen.coacen_mono.Service.Course_Material_Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Tag(name="Course Material",description = "ALl Operations related to course material")
@RequestMapping("/course_material")
@RestController
public class Course_Material_Controller
{
    @Autowired
    Course_Material_Service courseMaterialService;

    @Tag(name="Course Material",description = "Create new Course material")
    @PostMapping("/create_course_material")
    public ResponseEntity<Course_Material_return> create_course_material(@Valid @RequestBody Course_Material courseMaterial)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseMaterialService.create_course(courseMaterial));
    }

    @Tag(name="Course Material",description = "Get All Course Materials")
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/all_courses_material")
    public ResponseEntity<List<Course_Material_return>> get_all_course_materials()
    {
        return ResponseEntity.status(HttpStatus.OK).body(courseMaterialService.get_all_courses());
    }

    @Tag(name="Course Material",description = "Get Course Materials By Id")
    @GetMapping("/courses_material_byid/{id}")
    public ResponseEntity<Course_Material_return> get_all_course_materials(@PathVariable("id") int course_material_id) throws courseMaterialNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(courseMaterialService.get_course_byId(course_material_id));
    }

    @Tag(name="Course Material",description = "Update A Course Material by Id")
    @PutMapping("/update_course_material/{id}")
    public ResponseEntity<Course_Material_return> update_course_material_by_id(@Valid @PathVariable ("id") int course_material_id, @RequestBody Course_Material course_material) throws Exception {
        return ResponseEntity.status(HttpStatus.OK).body(courseMaterialService.update_course_material_by_id(course_material_id,course_material));
    }

    @Tag(name="Course Material",description = "Delete a Course Material by Id")
    @DeleteMapping("/delete_course_material/{id}")
    public ResponseEntity<HashMap<String,String>> delete_course_material(@PathVariable ("id") int course_material_id)
    {
        Boolean x=courseMaterialService.delete_parent_by_id(course_material_id);
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
