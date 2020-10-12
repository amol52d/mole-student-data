package com.student.data.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

}