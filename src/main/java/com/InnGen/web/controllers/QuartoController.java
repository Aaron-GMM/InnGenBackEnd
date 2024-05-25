package com.InnGen.web.controllers;

import com.InnGen.models.Quarto;
import com.InnGen.services.QuartoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/quarto")
public class QuartoController {
    @Autowired
    private QuartoService service;

    @GetMapping
    public ResponseEntity<List<Quarto>> findAll(){
        List<Quarto> list_quartos = service.findAll();
        return ResponseEntity.ok().body(list_quartos);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Quarto> findById(@PathVariable Long id){
        Quarto obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Quarto> insert(@RequestBody Quarto obj){
        obj =service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Quarto> update(@RequestBody Quarto obj){
        obj = service.update(obj);
        return ResponseEntity.ok().body(obj);
    }
}
