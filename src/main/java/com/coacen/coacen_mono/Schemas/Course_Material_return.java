package com.coacen.coacen_mono.Schemas;

import com.coacen.coacen_mono.Entity.Course_Material;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course_Material_return
{
    private String course_material_id;
    private String course_url;
    private int course_id;

    public Course_Material_return(Course_Material x) {
        this.course_material_id= String.valueOf(x.getCourse_material_id());
        this.course_url=x.getCourse_url();
        this.course_id=x.getCourse_id();
    }

}
