package com.javatechie.spring.soap.api.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;

@RestController
public class TestController {

    @GetMapping("/message")
    public String getMessage(){
        return "Server Connected";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello, SSL!";
    }


    @GetMapping("/getBase64Data")
    public String getBase64Data() {
        String base64File = "";
        File file = new File("/Users/samshabad.goud/Downloads/NFS_NTSL/AEPS0505252C_445.txt");
        try (FileInputStream imageInFile = new FileInputStream(file)) {
            // Reading a file from file system
            byte fileData[] = new byte[(int) file.length()];
            imageInFile.read(fileData);
            base64File = Base64.getEncoder().encodeToString(fileData);
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e);
        } catch (IOException ioe) {
            System.out.println("Exception while reading the file " + ioe);
        }
        return base64File;
    }

}