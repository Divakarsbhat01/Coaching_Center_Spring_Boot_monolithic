package com.coacen.coacen_mono.Schemas;

import com.coacen.coacen_mono.Entity.Teacher;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Teacher_return
{
    private String teacher_first_name;
    private String teacher_last_name;
    private String teacher_email;
    private int teacher_id;

    public Teacher_return(String teacher_first_name, String teacher_last_name, String teacher_email, int teacher_id) {
        this.teacher_first_name = teacher_first_name;
        this.teacher_last_name = teacher_last_name;
        this.teacher_email = teacher_email;
        this.teacher_id = teacher_id;
    }

    public Teacher_return(Teacher teacher)
    {
        this.teacher_first_name = teacher.getTeacher_first_name();
        this.teacher_last_name = teacher.getTeacher_last_name();
        this.teacher_email = teacher.getTeacher_email();
        this.teacher_id = teacher.getTeacher_id();
    }

    public String getTeacher_first_name() {
        return teacher_first_name;
    }

    public void setTeacher_first_name(String teacher_first_name) {
        this.teacher_first_name = teacher_first_name;
    }

    public String getTeacher_last_name() {
        return teacher_last_name;
    }

    public void setTeacher_last_name(String teacher_last_name) {
        this.teacher_last_name = teacher_last_name;
    }

    public String getTeacher_email() {
        return teacher_email;
    }

    public void setTeacher_email(String teacher_email) {
        this.teacher_email = teacher_email;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }
}
