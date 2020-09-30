package com.student.data.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Amol Dhekane
 * @version 1.1
 * @since 29/09/20 4:30 PM
 */
@Controller
@Slf4j
public class IndexController {

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/"
    )
    public String indexController(){
        return "index";
    }

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/process-input"
    )
    public String addStudentController(@RequestParam String whatToDo) {
        String returnVar;
        if(whatToDo=="addStudent"){
            log.info("This is a info statement will be printed in log file");
            returnVar = "add-student.jsp";
        }
        else {
            log.error("This is a error statement will be printed in log file");
            returnVar = "retrieve-all";
        }
        return returnVar;
    }
}