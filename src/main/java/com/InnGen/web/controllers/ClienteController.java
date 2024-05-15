package com.InnGen.web.controllers;

import com.InnGen.models.Cliente;
import com.InnGen.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;
    @GetMapping
    public ResponseEntity<List<Cliente>> finAll(){
        List<Cliente> list_clientes = service.findAll();
        return ResponseEntity.ok().body(list_clientes);
    }

}
