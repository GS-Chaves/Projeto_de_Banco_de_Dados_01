package com.curriculo.api.curriculo.controller;

import com.curriculo.api.curriculo.dto.BairroDTO;
import com.curriculo.api.curriculo.service.BairroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/bairro")
@CrossOrigin
public class BairroController {

    @Autowired
    private BairroService bairroService;

    @GetMapping
    public List<BairroDTO> findAll(){
        return bairroService.findAll();
    }

    @GetMapping("/{id}")
    public BairroDTO findById(@PathVariable("id") int id){
        return bairroService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody BairroDTO bairroDTO){
        bairroService.save(bairroDTO);
    }

    @PutMapping
    public BairroDTO update(@RequestBody BairroDTO bairroDTO){
        return bairroService.update(bairroDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BairroDTO> deleteById(@PathVariable("id") int id){
        bairroService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
