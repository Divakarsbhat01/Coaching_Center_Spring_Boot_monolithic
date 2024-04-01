package com.coacen.coacen_mono.Schemas;

import com.coacen.coacen_mono.Entity.Course_Material;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
public class Course_Material_return
{
    private int course_material_id;
    private String course_url;
    private int course_id;

    public Course_Material_return(Course_Material x)
    {
        this.course_material_id= x.getCourse_material_id();
        this.course_url=x.getCourse_url();
        this.course_id=x.getCourse_id();
    }
    public Course_Material_return(int course_material_id,String course_url,int course_id)
    {
        this.course_material_id= course_material_id;
        this.course_url=course_url;
        this.course_id=course_id;
    }

    public int getCourse_material_id() {
        return course_material_id;
    }

    public void setCourse_material_id(int course_material_id) {
        this.course_material_id = course_material_id;
    }

    public String getCourse_url() {
        return course_url;
    }

    public void setCourse_url(String course_url) {
        this.course_url = course_url;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
}
