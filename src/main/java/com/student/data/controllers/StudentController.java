package com.student.data.controllers;

import com.student.data.dao.Student;
import com.student.data.services.StudentService;
import com.student.data.utility.StudentSave;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Amol Dhekane
 * @version 1.1
 * @since 01/10/20 10:30 AM
 */
@RestController
@RequestMapping("/student")
@Slf4j
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

    @RequestMapping(
            path = "/search/id",
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8"
    )
    public List<Student> getIdStudent(@RequestParam(value = "retrievedId") Long retrievedId) {
        return studentService.getIdStudent(retrievedId);
    }

    @ExceptionHandler
    @RequestMapping(
            path = "/save",
            method = RequestMethod.POST,
            consumes = "application/json; charset:utf-8"
    )
    public Long saveStudent(@RequestBody StudentSave jsonData) {
        log.info(jsonData.getCourse());
        Student studentSave = new Student();
        studentSave.setName(jsonData.getName());
        studentSave.setAge(jsonData.getAge());
        studentSave.setCourse(jsonData.getCourse());
        log.info(studentSave.toString());
        return studentService.save(studentSave).getId();
    }
}
