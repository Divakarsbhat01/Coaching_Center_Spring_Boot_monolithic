package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="COURSE_MATERIAL")
public class Course_Material
{
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int course_material_id;
    private int course_id;
    private String course_url;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id",referencedColumnName = "course_id",insertable = false,updatable = false)
    private Course course;

}
