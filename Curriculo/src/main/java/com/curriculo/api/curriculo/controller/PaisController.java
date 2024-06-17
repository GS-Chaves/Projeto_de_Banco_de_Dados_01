package com.curriculo.api.curriculo.controller;

import com.curriculo.api.curriculo.dto.PaisDTO;
import com.curriculo.api.curriculo.service.PaisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pais")
@CrossOrigin
public class PaisController {

    @Autowired
    private PaisService paisService;

    @GetMapping
    public List<PaisDTO> findAll(){
        return paisService.findAll();
    }

    @GetMapping("/{id}")
    public PaisDTO findById(@PathVariable("id") int id){
        return paisService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody PaisDTO paisDTO){
        paisService.save(paisDTO);
    } 

    @PutMapping
    public PaisDTO update(@RequestBody PaisDTO paisDTO){
        return paisService.update(paisDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PaisDTO> deleteById(@PathVariable("id") int id){
        paisService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
