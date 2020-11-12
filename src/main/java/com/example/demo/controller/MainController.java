package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MainController.class);

    @RequestMapping(value = { "/", "/test" })
    public ResponseEntity<?> test(Model model) {
        LOGGER.info("\n-------- MainController.test --- ");
        LOGGER.info(" ** You are in Controller ** ");
        return new ResponseEntity<>("/, /test, success!", HttpStatus.OK);
    }

    // Đường dẫn này không còn sử dụng nữa.
    // Nó sẽ bị chuyển hướng bởi OldLoginInterceptor
    @RequestMapping(value = {"admin/oldlogin"})
    public ResponseEntity<?> oldLogin(Model model){
        LOGGER.info("You are in old login");
        return new ResponseEntity<>("oldLogin",HttpStatus.OK);
    }

    @RequestMapping(value = { "/admin/login" })
    public ResponseEntity<?> login(Model model) {
        LOGGER.info("\n-------- MainController.login --- ");
        LOGGER.info(" ** You are in Controller ** ");

        return new ResponseEntity<>("login", HttpStatus.OK);
    }
}
