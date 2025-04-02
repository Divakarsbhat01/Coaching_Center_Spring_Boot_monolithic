package com.coacen.coacen_mono.Repository;

import com.coacen.coacen_mono.Entity.Course;
import com.coacen.coacen_mono.Schemas.Course_Return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Course_Repository extends JpaRepository<Course,Integer>
{
    @Query(value="select new com.coacen.coacen_mono.Schemas.Course_Return(c.course_name,c.course_desc,c.course_credit,c.course_id) from Course c")
    List<Course_Return> get_all_courses();
}
