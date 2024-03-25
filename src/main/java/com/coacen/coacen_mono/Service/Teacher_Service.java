package com.coacen.coacen_mono.Service;

import com.coacen.coacen_mono.Entity.Teacher;
import com.coacen.coacen_mono.Schemas.Teacher_return;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface Teacher_Service
{

    Teacher_return create_teacher(Teacher teacher);

    List<Teacher> get_all_teachers();

    Optional<Teacher> get_teacher_byId(int teacherId);

    Teacher update_teacher_by_id(int teacherId, Teacher teacher) throws Exception;

    Boolean delete_teacher_by_id(int teacherId);
}
