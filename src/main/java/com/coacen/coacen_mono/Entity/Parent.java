package com.coacen.coacen_mono.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="PARENT")
public class Parent
{
    private String parent_first_name;
    private String parent_last_name;
    private String parent_email;
    private String parent_mobile;
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private int parent_id;
}
