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
    private String course_material_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id",referencedColumnName = "course_id")
    private Course course;
    private String course_url;
}
