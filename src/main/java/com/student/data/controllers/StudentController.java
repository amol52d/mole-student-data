package com.student.data.controllers;

import com.student.data.dao.Student;
import com.student.data.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Amol Dhekane
 * @version 1.1
 * @since 01/10/20 10:30 AM
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(
            path = "/list",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8"
    )
    public List<Student> getAllStudent(){
        return studentService.getAllStudents();
    }

    public List<Student> getIdStudent() {
        @RequestParam(value = "student_id") int student_id;
        return studentService.getIdStudent(); }
}
