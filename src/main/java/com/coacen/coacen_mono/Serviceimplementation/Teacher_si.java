package com.coacen.coacen_mono.Serviceimplementation;

import com.coacen.coacen_mono.Entity.Teacher;
import com.coacen.coacen_mono.Error_Control.Exceptions.teacherNotFoundException;
import com.coacen.coacen_mono.Repository.Teacher_Repository;
import com.coacen.coacen_mono.Schemas.Teacher_return;
import com.coacen.coacen_mono.Service.Teacher_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Teacher_si implements Teacher_Service
{
    @Autowired
    Teacher_Repository teacherRepository;

    @CacheEvict(value = {"getListOfAllTeachers","getListOfTeachersById"},allEntries = true)
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

    @Cacheable(value = "getListOfAllTeachers")
    @Override
    public List<Teacher_return> get_all_teachers()
    {
        return teacherRepository.getAllTeachers();
    }

    @Cacheable(value = "getListOfTeachersById")
    @Transactional
    @Override
    public Teacher_return get_teacher_byId(int teacherId) throws teacherNotFoundException {
        if(teacherRepository.findById(teacherId).isPresent())
        {
            Teacher_return tr=new Teacher_return(teacherRepository.findById(teacherId).get());
            return tr;
        }
        else
        {
            throw new teacherNotFoundException("TeacherId not found");
        }
    }

    @CachePut(value ={"getListOfAllTeachers","getListOfTeachersById"})
    @Transactional
    @Override
    public Teacher_return update_teacher_by_id(int teacherId, Teacher teacher) throws Exception
    {
        if(teacherRepository.findById(teacherId).isPresent())
        {
            Teacher x=teacherRepository.getReferenceById(teacherId);
            x.setTeacher_email(teacher.getTeacher_email());
            x.setTeacher_first_name(teacher.getTeacher_first_name());
            x.setTeacher_last_name(teacher.getTeacher_last_name());
            teacherRepository.save(x);
            Teacher_return teacherReturn=new Teacher_return();
            teacherReturn.setTeacher_id(x.getTeacher_id());
            teacherReturn.setTeacher_email(x.getTeacher_email());
            teacherReturn.setTeacher_first_name(x.getTeacher_first_name());
            teacherReturn.setTeacher_last_name(x.getTeacher_last_name());
            return teacherReturn;
        }
        else
        {
            throw new teacherNotFoundException("TeacherId not found");
        }
    }

    @CacheEvict(value = {"getListOfAllTeachers","getListOfTeachersById"},allEntries = true)
    @Transactional
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
