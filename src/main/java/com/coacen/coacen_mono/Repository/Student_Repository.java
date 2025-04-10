package com.coacen.coacen_mono.Repository;

import com.coacen.coacen_mono.Entity.Student;
import com.coacen.coacen_mono.Schemas.StudentList;
import com.coacen.coacen_mono.Schemas.Student_return;
import com.coacen.coacen_mono.Schemas.parent_return;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface Student_Repository extends JpaRepository<Student,Integer>
{
    @Query("select new com.coacen.coacen_mono.Schemas.Student_return(a.student_id,a.student_first_name,a.student_last_name,a.email_id,a.student_age,a.parent_id) from Student a ")
    public List<Student_return> returnAllStudents();

    @Query("SELECT new com.coacen.coacen_mono.Schemas.StudentList(a.student_first_name,c.course_name) from Student a join Student_Course b on a.student_id=b.studentId  Join Course c on b.courseId=c.course_id where c.course_name='kannada'")
    public List<StudentList>abcd();
}
