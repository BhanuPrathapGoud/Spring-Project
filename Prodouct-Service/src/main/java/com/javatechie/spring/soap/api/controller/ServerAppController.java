package com.javatechie.spring.soap.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/server-app")
public class ServerAppController {
    @RequestMapping(value = "/data", method = RequestMethod.GET)
    public String getData() {
        System.out.println("Returning data from server-app data method");
        return "Hello from Server-App-data method";
    }


    @GetMapping(value = "/data/", produces = "application/xml")
    public DataResponse getData2() {
        System.out.println("Returning data from server-app data method");
        return new DataResponse("Hello from Server-App-data method");
    }

}
