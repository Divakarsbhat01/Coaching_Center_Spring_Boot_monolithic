package com.coacen.coacen_mono.Serviceimplementation;

import com.coacen.coacen_mono.Entity.Course_Material;
import com.coacen.coacen_mono.Error_Control.Exceptions.courseMaterialNotFoundException;
import com.coacen.coacen_mono.Error_Control.Exceptions.courseNotFoundException;
import com.coacen.coacen_mono.Repository.Course_Material_Repository;
import com.coacen.coacen_mono.Schemas.Course_Material_return;
import com.coacen.coacen_mono.Service.Course_Material_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class Course_Material_si implements Course_Material_Service
{
    @Autowired
    Course_Material_Repository courseMaterialRepository;

    @CacheEvict(value={"listOfCourseMaterialById","listOfAllCoursesMaterial"},allEntries = true)
    @Override
    public Course_Material_return create_course(Course_Material courseMaterial)
    {
        Course_Material x=courseMaterialRepository.save(courseMaterial);
        Course_Material_return cmr=new Course_Material_return(x);
        return cmr;
    }

    @Cacheable(value="listOfAllCoursesMaterial")
    @Override
    public List<Course_Material_return> get_all_courses()
    {
        return courseMaterialRepository.return_all_coursematerials();
    }

    @Cacheable(value="listOfCourseMaterialById")
    @Transactional
    @Override
    public Course_Material_return get_course_byId(int courseMaterialId) throws courseMaterialNotFoundException {
        if(courseMaterialRepository.findById(courseMaterialId).isPresent())
        {
            Course_Material_return cmr=new Course_Material_return(courseMaterialRepository.findById(courseMaterialId).get());
            return cmr;
        }
        else
        {
         throw new courseMaterialNotFoundException("Course Material not found");
        }
    }

    @CachePut(value = {"listOfCourseMaterialById","listOfAllCoursesMaterial"})
    @Transactional
    @Override
    public Course_Material_return update_course_material_by_id(int courseMaterialId, Course_Material courseMaterial) throws Exception {
        if(courseMaterialRepository.findById(courseMaterialId).isPresent())
        {
            Course_Material x=courseMaterialRepository.getReferenceById(courseMaterialId);
            x.setCourse_id(courseMaterial.getCourse_id());
            x.setCourse(courseMaterial.getCourse());
            x.setCourse_url(courseMaterial.getCourse_url());
            courseMaterialRepository.save(x);
            Course_Material_return xx=new Course_Material_return(x);
            return xx;
        }
        else
        {
            throw new courseNotFoundException("CourseId not found");
        }
    }

    @Transactional
    @Override
    @CacheEvict(value={"listOfCourseMaterialById","listOfAllCoursesMaterial"},allEntries = true)
    public Boolean delete_parent_by_id(int courseMaterialId)
    {
        if (courseMaterialRepository.findById(courseMaterialId).isPresent())
        {
            courseMaterialRepository.deleteById(courseMaterialId);
            return Boolean.TRUE;
        }
        else {
            return Boolean.FALSE;
        }
    }
}
