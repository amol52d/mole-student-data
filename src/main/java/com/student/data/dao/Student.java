package com.student.data.dao;


import lombok.Data;
//import org.springframework.data.annotation.Id;

import javax.persistence.*;

/**
 * @author Amol Dhekane
 * @version 1.1
 * @since 01/10/20 10:20 AM
 */
@Entity
@Table(name = "Students")
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;
    @Column(name = "student_name")
    private String name;
    @Column(name = "student_age")
    private int age;
    @Column(name = "student_course")
    private String course;
}
