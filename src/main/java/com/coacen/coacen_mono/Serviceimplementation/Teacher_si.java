package com.coacen.coacen_mono.Serviceimplementation;

import com.coacen.coacen_mono.Entity.Student;
import com.coacen.coacen_mono.Entity.Teacher;
import com.coacen.coacen_mono.Repository.Teacher_Repository;
import com.coacen.coacen_mono.Schemas.Student_return;
import com.coacen.coacen_mono.Schemas.Teacher_return;
import com.coacen.coacen_mono.Service.Teacher_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Teacher_si implements Teacher_Service
{
    @Autowired
    Teacher_Repository teacherRepository;
    @Override
    public Teacher_return create_teacher(Teacher teacher)
    {
        Teacher x=teacherRepository.save(teacher);
        Teacher_return teacherReturn=new Teacher_return();
        teacherReturn.setTeacher_first_name(teacher.getTeacher_first_name());
        teacherReturn.setTeacher_last_name(teacher.getTeacher_last_name());
        teacherReturn.setTeacher_id(teacher.getTeacher_id());
        teacherReturn.setTeacher_email(teacher.getTeacher_email());
        return teacherReturn;
    }

    @Override
    public List<Teacher> get_all_teachers()
    {
        return teacherRepository.findAll();
    }

    @Override
    public Optional<Teacher> get_teacher_byId(int teacherId)
    {
        return teacherRepository.findById(teacherId);
    }

    @Override
    public Teacher update_teacher_by_id(int teacherId, Teacher teacher) throws Exception {
        if(teacherRepository.findById(teacherId).isPresent())
        {
            return teacherRepository.save(teacher);
        }
        throw new Exception("The user is not present");
    }

    @Override
    public Boolean delete_teacher_by_id(int teacherId)
    {
        if (teacherRepository.findById(teacherId).isPresent())
        {
            teacherRepository.deleteById(teacherId);
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}
