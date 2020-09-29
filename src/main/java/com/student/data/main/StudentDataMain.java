package com.student.data.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author shivjha
 * @since 30-01-2020
 * @version 1
 */
@SpringBootApplication
@EnableScheduling
public class StudentDataMain {

    public static void main(String[] args) {
        SpringApplication.run(StudentDataMain.class, args);
    }
}