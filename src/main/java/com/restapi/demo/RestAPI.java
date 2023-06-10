package com.restapi.demo;

import org.springframework.web.bind.annotation.*;

@RestController
public class RestAPI {
    @RequestMapping(method = RequestMethod.GET, path="/books")
    public String GetAll(){
        return "getall";
    }
    @RequestMapping(method = RequestMethod.POST, path="/add")
    public String Add(@RequestBody Book book){ // Book 클래스를 참조한다는 뜻. -> book 객체로 다룰 예정.
        return "Add";
    }
    @RequestMapping(method = RequestMethod.PUT, path="/update/{id}")
    public String Update(@RequestBody Book book, @PathVariable int id){
        return "Update";
    }
    @RequestMapping(method = RequestMethod.DELETE, path="/delete/{id}")
    public String Delete(@PathVariable int id){
        return "Delete";
    }
}
