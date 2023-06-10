package com.restapi.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Hello {

    @RequestMapping(method = RequestMethod.GET , path="/")
    public String world(){
        return "index.html";
    }

}
