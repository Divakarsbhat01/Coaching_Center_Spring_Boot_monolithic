package com.coacen.coacen_mono.Repository;

import com.coacen.coacen_mono.Entity.Teacher_Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Teacher_Course_Repository extends JpaRepository<Teacher_Course,Integer>
{

}
