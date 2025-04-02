package com.coacen.coacen_mono.Schemas;

import com.coacen.coacen_mono.Entity.Course;
import com.coacen.coacen_mono.Entity.Parent;
import com.coacen.coacen_mono.Entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
@Data
@NoArgsConstructor
public class Student_return
{
        private int student_id;
        private String student_first_name;
        private String student_last_name;
        private String email_id;
        private int student_age;
        private int parent_id;

        public Student_return(int student_id, String student_first_name, String student_last_name, String email_id, int student_age, int parent_id) {
                this.student_id = student_id;
                this.student_first_name = student_first_name;
                this.student_last_name = student_last_name;
                this.email_id = email_id;
                this.student_age = student_age;
                this.parent_id = parent_id;
        }

        public Student_return(Student student)
        {
                this.student_id =student.getStudent_id();
                this.student_first_name = student.getStudent_first_name();
                this.student_last_name = student.getStudent_last_name();
                this.email_id = student.getEmail_id();
                this.student_age =student.getStudent_age();
                this.parent_id = student.getParent_id();
        }

        public int getStudent_id() {
                return student_id;
        }

        public void setStudent_id(int student_id) {
                this.student_id = student_id;
        }

        public String getStudent_first_name() {
                return student_first_name;
        }

        public void setStudent_first_name(String student_first_name) {
                this.student_first_name = student_first_name;
        }

        public String getStudent_last_name() {
                return student_last_name;
        }

        public void setStudent_last_name(String student_last_name) {
                this.student_last_name = student_last_name;
        }

        public String getEmail_id() {
                return email_id;
        }

        public void setEmail_id(String email_id) {
                this.email_id = email_id;
        }

        public int getStudent_age() {
                return student_age;
        }

        public void setStudent_age(int student_age) {
                this.student_age = student_age;
        }

        public int getParent_id() {
                return parent_id;
        }

        public void setParent_id(int parent_id) {
                this.parent_id = parent_id;
        }
}
