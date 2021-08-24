package com.rsr.furad.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 13375
 */
@Controller
public class MainController {

    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }
}
