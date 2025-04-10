package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Course ID Required")
    private int course_id;

    @NotNull(message = "Course URL Required")
    private String course_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",referencedColumnName = "course_id",insertable = false,updatable = false)
    private Course course;

}
