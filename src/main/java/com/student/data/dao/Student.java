package com.student.data.dao;


import lombok.Data;

import javax.persistence.*;

/**
 * @author Amol Dhekane
 * @version 1.1
 * @since 01/10/20 10:20 AM
 */
@Entity
@Table(name = "student_data")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_age")
    private int age;
    @Column(name = "student_course")
    private String course;

}
