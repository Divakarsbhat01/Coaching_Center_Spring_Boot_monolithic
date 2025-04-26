package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Entity.Parent;
import com.coacen.coacen_mono.Error_Control.Exceptions.parentNotFoundException;
import com.coacen.coacen_mono.Schemas.parent_return;
import com.coacen.coacen_mono.Service.Parent_Service;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RequestMapping("/parent")
@Tag(name="Parent",description = "ALl Operations related to Parent")
@RestController
public class Parent_Controller
{
    @Autowired
    Parent_Service parentService;

    @Tag(name="Parent",description = "Create Parent")
    @PostMapping("/create_parent")
    public ResponseEntity<Parent> create_parent(@Valid @RequestBody Parent parent)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(parentService.create_parent(parent));
    }

    @Tag(name="Parent",description = "Get All Parents")
    @GetMapping("/all_parents")
    public ResponseEntity<List<Parent>> get_all_parents()
    {
        return ResponseEntity.status(HttpStatus.OK).body(parentService.get_all_parents());
    }

    @Tag(name="Parent",description = "Get a Parent by Id")
    @GetMapping("/parents_by_id/{id}")
    public ResponseEntity<Optional<Parent>> get_all_parents(@PathVariable ("id") int parent_id) throws parentNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(parentService.get_parent_byId(parent_id));
    }

    @Tag(name="Parent",description = "Update a Parent by Id")
    @PutMapping("/update_parent/{id}")
    public ResponseEntity<Parent> update_parent_by_id(@Valid @PathVariable ("id") int parent_id,@RequestBody Parent parent) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(parentService.update_parent_by_id(parent_id,parent));
    }

    @Tag(name="Parent",description = "Delete A Parent by Id")
    @DeleteMapping("/delete_parent/{id}")
    public ResponseEntity<HashMap<String,String>>delete_parent(@PathVariable ("id") int parent_id)
    {
        Boolean x=parentService.delete_parent_by_id(parent_id);
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

    @GetMapping("/parret")
    public List<parent_return> ret_all_parent()
    {
        return parentService.return_all_parents();
    }
}
