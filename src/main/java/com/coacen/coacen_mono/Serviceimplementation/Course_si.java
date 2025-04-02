package com.coacen.coacen_mono.Serviceimplementation;

import com.coacen.coacen_mono.Entity.Course;
import com.coacen.coacen_mono.Error_Control.Exceptions.courseNotFoundException;
import com.coacen.coacen_mono.Repository.Course_Repository;
import com.coacen.coacen_mono.Schemas.Course_Return;
import com.coacen.coacen_mono.Service.Course_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.validation.Validator;
import java.util.List;
import java.util.Optional;

@Service
public class Course_si implements Course_Service
{
    @Autowired
    Course_Repository courseRepository;

    @CacheEvict(value = {"listOfCourseById","listOfAllCourses"},allEntries = true)
    @Override
    public Course_Return create_course(Course course)
    {
        Course x=courseRepository.save(course);
        Course_Return cr=new Course_Return();
        cr.setCourse_name(x.getCourse_name());
        cr.setCourse_desc(x.getCourse_desc());
        cr.setCourse_id(x.getCourse_id());
        cr.setCourse_credit(x.getCourse_credit());
        return cr;
    }

    @Cacheable(value = "listOfAllCourses")
    @Override
    public List<Course_Return> get_all_courses()
    {

        return courseRepository.get_all_courses();
    }

    @Cacheable(value = "listOfCourseById")
    @Transactional
    @Override
    public Course_Return get_course_byId(int courseId) throws courseNotFoundException {
        if(courseRepository.findById(courseId).isPresent())
        {
            Course_Return cr=new Course_Return(courseRepository.findById(courseId).get());
            return cr;
        }
        else
        {
            throw new courseNotFoundException("CourseId not found");
        }
    }

    @CachePut(value = {"listOfCourseById","listOfAllCourses"})
    @Transactional
    @Override
    public Course_Return update_course_by_id(int courseId, Course course) throws Exception
    {
        if(courseRepository.findById(courseId).isPresent())
        {
            Course x=courseRepository.getReferenceById(courseId);
            x.setCourse_credit(course.getCourse_credit());
            x.setCourse_name(course.getCourse_name());
            x.setCourse_desc(course.getCourse_desc());
            courseRepository.save(x);
            Course_Return xx=new Course_Return(x);
            return xx;

        }
        else
        {
            throw new courseNotFoundException("CourseId not found");
        }
    }

    @CacheEvict(value = {"listOfCourseById","listOfAllCourses"},allEntries = true)
    @Transactional
    @Override
    public Boolean delete_parent_by_id(int courseId) {
        if (courseRepository.findById(courseId).isPresent())
        {
            courseRepository.deleteById(courseId);
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}
