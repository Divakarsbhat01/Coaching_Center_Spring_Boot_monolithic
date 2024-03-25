package com.coacen.coacen_mono.Controller;

import com.coacen.coacen_mono.Entity.Parent;
import com.coacen.coacen_mono.Service.Parent_Service;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Parent create_parent(@RequestBody Parent parent)
    {
        return parentService.create_parent(parent);
    }

    @GetMapping("/all_parents")
    public List<Parent> get_all_parents()
    {
        return parentService.get_all_parents();
    }
    @GetMapping("/parents_by_id/{id}")
    public Optional<Parent> get_all_parents(@PathVariable ("id") int parent_id)
    {

        return parentService.get_parent_byId(parent_id);
    }
    @PutMapping("/update_parent/{id}")
    public Parent update_parent_by_id(@PathVariable ("id") int parent_id,@RequestBody Parent parent) throws Exception {
        return parentService.update_parent_by_id(parent_id,parent);
    }
    @DeleteMapping("/delete_parent/{id}")
    public HashMap<String,String>delete_parent(@PathVariable ("id") int parent_id)
    {
        Boolean x=parentService.delete_parent_by_id(parent_id);
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
