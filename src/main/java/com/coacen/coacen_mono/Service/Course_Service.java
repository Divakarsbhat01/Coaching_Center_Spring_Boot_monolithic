package com.coacen.coacen_mono.Service;

import com.coacen.coacen_mono.Entity.Course;
import com.coacen.coacen_mono.Error_Control.Exceptions.courseNotFoundException;
import com.coacen.coacen_mono.Schemas.Course_Return;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Course_Service
{

    Course_Return create_course(Course parent);

    List<Course_Return> get_all_courses();

    Course_Return get_course_byId(int courseId) throws courseNotFoundException;

    Course_Return update_course_by_id(int courseId, Course course) throws Exception;

    Boolean delete_parent_by_id(int courseId);
}
