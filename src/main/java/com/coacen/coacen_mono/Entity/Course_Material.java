package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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

    @Id
    @SequenceGenerator(name="courseMaterialSequence",sequenceName = "courseMaterialSequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "courseMaterialSequence")
    @Column(name = "course_material_id")
    private int course_material_id;

    @Min(value = 1,message = "Course Id Cannot be Zero or Negative")
    @NotNull(message = "Course ID Required")
    @Column(name = "course_id")
    private int course_id;

    @Size(min = 3,message = "PLease mention Correct URL")
    @NotNull(message = "Course URL Required")
    private String course_url;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",referencedColumnName = "course_id",insertable = false,updatable = false)
    private Course course;

}
