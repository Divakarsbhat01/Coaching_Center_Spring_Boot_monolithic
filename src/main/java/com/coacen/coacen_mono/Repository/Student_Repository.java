package com.coacen.coacen_mono.Repository;

import com.coacen.coacen_mono.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Student_Repository extends JpaRepository<Student,Integer> {
}
