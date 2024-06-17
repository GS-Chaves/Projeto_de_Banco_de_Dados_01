package com.curriculo.api.curriculo.controller;

import com.curriculo.api.curriculo.dto.ExpProfissionalDTO;
import com.curriculo.api.curriculo.service.ExpProfissionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/exp-profissional")
@CrossOrigin
public class ExpProfissionalController {

    @Autowired
    private ExpProfissionalService expProfissionalService;

    @GetMapping
    public List<ExpProfissionalDTO> findAll(){
        return expProfissionalService.findAll();
    }

    @GetMapping("/{id}")
    public ExpProfissionalDTO findById(@PathVariable("id") int id){
        return expProfissionalService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody ExpProfissionalDTO expProfissionalDTO){
        expProfissionalService.save(expProfissionalDTO);
    }

    @PutMapping
    public ExpProfissionalDTO update(@RequestBody ExpProfissionalDTO expProfissionalDTO){
        return expProfissionalService.update(expProfissionalDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ExpProfissionalDTO> deleteById(@PathVariable("id") int id){
        expProfissionalService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
