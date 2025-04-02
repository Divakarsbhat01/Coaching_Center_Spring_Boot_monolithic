package com.coacen.coacen_mono.Repository;

import com.coacen.coacen_mono.Entity.Teacher;
import com.coacen.coacen_mono.Schemas.Teacher_return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Teacher_Repository extends JpaRepository<Teacher,Integer>
{
    @Query("select new com.coacen.coacen_mono.Schemas.Teacher_return(a.teacher_first_name,a.teacher_last_name,a.teacher_email,a.teacher_id) from Teacher a ")
    public List<Teacher_return> getAllTeachers();
}
