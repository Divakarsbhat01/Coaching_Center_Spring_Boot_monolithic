package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Entity.Parent;
import com.coacen.coacen_mono.Error_Control.Exceptions.parentNotFoundException;
import com.coacen.coacen_mono.Schemas.parent_return;
import com.coacen.coacen_mono.Service.Parent_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@RestController
public class Parent_Controller
{
    @Autowired
    Parent_Service parentService;

    @PostMapping("/create_parent")
    public ResponseEntity<Parent> create_parent(@Valid @RequestBody Parent parent)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(parentService.create_parent(parent));
    }

    @GetMapping("/all_parents")
    public ResponseEntity<List<Parent>> get_all_parents()
    {
        return ResponseEntity.status(HttpStatus.OK).body(parentService.get_all_parents());
    }

    @GetMapping("/parents_by_id/{id}")
    public ResponseEntity<Optional<Parent>> get_all_parents(@PathVariable ("id") int parent_id) throws parentNotFoundException {

        return ResponseEntity.status(HttpStatus.OK).body(parentService.get_parent_byId(parent_id));
    }
    @PutMapping("/update_parent/{id}")
    public ResponseEntity<Parent> update_parent_by_id(@Valid @PathVariable ("id") int parent_id,@RequestBody Parent parent) throws Exception
    {
        return ResponseEntity.status(HttpStatus.OK).body(parentService.update_parent_by_id(parent_id,parent));
    }
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
