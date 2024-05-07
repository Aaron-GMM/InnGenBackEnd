package com.InnGen.web.controllers;

import com.InnGen.models.User;
import com.InnGen.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
     public ResponseEntity<List<User>> findAll(){
        List<User> list_user = service.findAll();
        return ResponseEntity.ok().body(list_user);
    }


}
