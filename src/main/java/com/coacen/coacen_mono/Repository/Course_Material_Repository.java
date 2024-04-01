package com.coacen.coacen_mono.Repository;

import com.coacen.coacen_mono.Entity.Course_Material;
import com.coacen.coacen_mono.Schemas.Course_Material_return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface Course_Material_Repository extends JpaRepository<Course_Material,Integer>
{
    @Query(value = "select new com.coacen.coacen_mono.Schemas.Course_Material_return(a.course_material_id,a.course_url,a.course_id) from Course_Material a")
    public List<Course_Material_return> return_all_coursematerials();
}

