package com.coacen.coacen_mono.Schemas;

import com.coacen.coacen_mono.Entity.Course;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course_Return
{
    private String course_name;
    private String course_desc;
    private int course_credit;
    private int course_id;

    public Course_Return(Course x)
    {
        this.course_name=x.getCourse_name();
        this.course_credit=x.getCourse_credit();
        this.course_desc=x.getCourse_desc();
        this.course_id=x.getCourse_id();

    }
}
