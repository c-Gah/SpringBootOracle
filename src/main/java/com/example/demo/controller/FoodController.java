package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.FruitRepository;
import com.example.demo.service.FoodService;

@RestController
public class FoodController {
    @Autowired
    FoodService testService;

    @Autowired
    private FruitRepository fruitRepository;
    
    @GetMapping("/")
    public String index(){
        return testService.getTestData();
        // return "Hello World22";
        // response.sendRedirect("/hello");
    }

    @GetMapping("/test")
    public String test(){
        return testService.callOraclePackage().get(0).getName();
        // return "Hello World22";
        // response.sendRedirect("/hello");
    }

    @GetMapping("/test2")
    public String test2(){
        String returnValue = "";
        for(Double val : testService.callOraclePackage2()) {
            returnValue = returnValue + val + "\t";
        }
        return returnValue;
    }

    @GetMapping("/test25")
    public String test25(){
        String returnValue = "";
        for(Double val : testService.callOraclePackage25()) {
            returnValue = returnValue + val + "\t";
        }
        return returnValue;
    }

    @GetMapping("/test3")
    public String test3(){
        String returnValue = "";
        for(Double val : testService.callOraclePackage3()) {
            returnValue = returnValue + val + "\t";
        }
        return returnValue;
    }

    @GetMapping("/test4")
    public String test4() throws Exception{
        return testService.callOraclePackage4();
    }


    @GetMapping("/test5")
    public String test5() throws Exception{
        return testService.callOraclePackage5();
    }

    @GetMapping("/test6")
    public String test6() throws Exception{
        return testService.callOraclePackage6();
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello World2233";
    }
}
