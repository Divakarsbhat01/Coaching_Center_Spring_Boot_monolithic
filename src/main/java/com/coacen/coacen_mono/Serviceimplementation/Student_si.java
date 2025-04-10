package com.coacen.coacen_mono.Serviceimplementation;

import com.coacen.coacen_mono.Entity.Student;
import com.coacen.coacen_mono.Error_Control.Exceptions.studentNotFoundException;
import com.coacen.coacen_mono.Repository.Student_Repository;
import com.coacen.coacen_mono.Schemas.StudentList;
import com.coacen.coacen_mono.Schemas.Student_return;
import com.coacen.coacen_mono.Service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Student_si implements Student_Service
{
    @Autowired
    Student_Repository studentRepository;

    @CacheEvict(value = {"getListOfAllStudents","getListOfStudentById"},allEntries = true)
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

    @Cacheable(value = "getListOfAllStudents")
    @Override
    public List<Student_return> get_all_students()
    {
        return studentRepository.returnAllStudents();
    }

    @Cacheable(value = "getListOfStudentById")
    @Transactional
    public Student_return get_student_byId(int student_id) throws studentNotFoundException {
        if(studentRepository.findById(student_id).isPresent())
        {
            Student_return sr=new Student_return(studentRepository.findById(student_id).get());
            return sr;
        }
        else
        {
            throw new studentNotFoundException("Student Id not Found");
        }
    }

    @CachePut(value = {"getListOfAllStudents","getListOfStudentById"})
    @Transactional
    @Override
    public Student_return update_student_by_id(int studentId, Student student) throws Exception {
        if(studentRepository.findById(studentId).isPresent())
        {
            Student x=studentRepository.findById(studentId).get();
            x.setStudent_id(student.getStudent_id());
            x.setStudent_age(student.getStudent_age());
            x.setStudent_first_name(student.getStudent_first_name());
            x.setStudent_last_name(student.getStudent_last_name());
            x.setEmail_id(student.getEmail_id());
            x.setParent_id(student.getParent_id());
            studentRepository.save(x);
            return new Student_return(x);
        }
        else
        {
            throw new studentNotFoundException("Student Id not Found");
        }
    }

    @CacheEvict(value = {"getListOfAllStudents","getListOfStudentById"},allEntries = true)
    @Transactional
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

    public List<StudentList> abcdef()
    {
        return studentRepository.abcd();
    }
}
