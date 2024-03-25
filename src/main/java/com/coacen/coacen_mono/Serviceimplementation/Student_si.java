package com.coacen.coacen_mono.Serviceimplementation;

import com.coacen.coacen_mono.Entity.Student;
import com.coacen.coacen_mono.Repository.Student_Repository;
import com.coacen.coacen_mono.Schemas.Student_return;
import com.coacen.coacen_mono.Service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Student_si implements Student_Service
{
    @Autowired
    Student_Repository studentRepository;

    public Student_return create_student(Student student)
    {
        Student x=studentRepository.save(student);
        Student_return studentReturn=new Student_return();
        studentReturn.setStudent_age(student.getStudent_age());
        studentReturn.setStudent_first_name(student.getStudent_first_name());
        studentReturn.setStudent_last_name(student.getStudent_last_name());
        studentReturn.setStudent_id(student.getStudent_id());
        studentReturn.setParent_id(student.getParent_id());
        studentReturn.setEmail_id(student.getEmail_id());
        return studentReturn;
    }

    public List<Student> get_all_students() {
        return studentRepository.findAll();
    }

    public Optional<Student> get_student_byId(int student_id) {
        return studentRepository.findById(student_id);
    }

    @Override
    public Student update_student_by_id(int studentId, Student student) throws Exception {
        if(studentRepository.findById(studentId).isPresent())
        {
            return studentRepository.save(student);
        }
        throw new Exception("The user is not present");
    }

    @Override
    public Boolean delete_student_by_id(int studentId)
    {
        if (studentRepository.findById(studentId).isPresent())
        {
            studentRepository.deleteById(studentId);
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}
