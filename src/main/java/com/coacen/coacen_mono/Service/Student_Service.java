package com.coacen.coacen_mono.Service;

import com.coacen.coacen_mono.Entity.Student;
import com.coacen.coacen_mono.Error_Control.Exceptions.studentNotFoundException;
import com.coacen.coacen_mono.Schemas.Student_return;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Student_Service{
    Student_return create_student(Student student);

    List<Student_return> get_all_students();

    Student_return get_student_byId(int studentId) throws studentNotFoundException;

    Student_return update_student_by_id(int studentId, Student student) throws Exception;

    Boolean delete_student_by_id(int studentId);
}
