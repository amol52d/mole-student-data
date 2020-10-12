package com.student.data.controllers;

import com.student.data.dao.Student;
import com.student.data.services.StudentService;
import com.student.data.utility.StudentSave;
import com.student.data.utility.model.UniversalResponsePayload;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public UniversalResponsePayload getAllStudent(HttpServletResponse response){
        UniversalResponsePayload responsePayload = new UniversalResponsePayload();
        try{
            List<Student> students = studentService.getAllStudents();
            responsePayload.setStatus(HttpServletResponse.SC_OK);
            responsePayload.setData(students);
            responsePayload.setMessage("Ok");
        }catch (Exception e){
            log.error(e.toString());
            responsePayload.setMessage(e.getMessage());
            responsePayload.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        response.setStatus(responsePayload.getStatus());
        return responsePayload;
    }

    @RequestMapping(
            path = "/search/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public UniversalResponsePayload searchStudentById(@PathVariable("id") String searchId,
                                                      HttpServletResponse response) {
        UniversalResponsePayload responsePayloadSearch = new UniversalResponsePayload();
        try{
            List<Student> students = studentService.getIdStudent(Long.valueOf(searchId));
            responsePayloadSearch.setStatus(HttpServletResponse.SC_OK);
            responsePayloadSearch.setData(students);
            responsePayloadSearch.setMessage("Ok");
        }catch (Exception e){
            log.error(e.toString());
            responsePayloadSearch.setMessage(e.getMessage());
            responsePayloadSearch.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        response.setStatus(responsePayloadSearch.getStatus());
        return responsePayloadSearch;
    }

    @RequestMapping(
            path = "/save",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public UniversalResponsePayload saveStudent(@RequestBody StudentSave jsonData,
                                                HttpServletResponse response) {
        UniversalResponsePayload responsePayload = new UniversalResponsePayload();
        try{
            Student student = new Student();
            student.setName(jsonData.getName());
            student.setAge(jsonData.getAge());
            student.setCourse(jsonData.getCourse());
            student = studentService.save(student);

            responsePayload.setData(student);
            responsePayload.setStatus(HttpServletResponse.SC_OK);
            responsePayload.setMessage("Ok");
        }catch (Exception e){
            log.error(e.toString());
            responsePayload.setMessage(e.getMessage());
            responsePayload.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        response.setStatus(responsePayload.getStatus());
        return responsePayload;
    }

    @RequestMapping(
            path = "/delete/{id}",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE
    )
    public UniversalResponsePayload deleteStudentById(@PathVariable("id") String studentId,
                                                      HttpServletResponse response) {
        UniversalResponsePayload responsePayloadDelete = new UniversalResponsePayload();
        try{
            studentService.deleteStudent(Long.valueOf(studentId));
            responsePayloadDelete.setStatus(HttpServletResponse.SC_OK);
            responsePayloadDelete.setData(null);
            responsePayloadDelete.setMessage("Ok");
        }catch (Exception e){
            log.error(e.toString());
            responsePayloadDelete.setMessage(e.getMessage());
            responsePayloadDelete.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        response.setStatus(responsePayloadDelete.getStatus());
        return responsePayloadDelete;
    }
}