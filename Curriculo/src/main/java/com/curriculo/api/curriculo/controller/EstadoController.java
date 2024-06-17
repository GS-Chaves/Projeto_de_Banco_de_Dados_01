package com.curriculo.api.curriculo.controller;

import com.curriculo.api.curriculo.dto.EstadoDTO;
import com.curriculo.api.curriculo.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/estado")
@CrossOrigin
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public List<EstadoDTO> findAll(){
        return estadoService.findAll();
    }

    @GetMapping("/{id}")
    public EstadoDTO findById(@PathVariable("id") int id){
        return estadoService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody EstadoDTO estadoDTO){
        estadoService.save(estadoDTO);
    }

    @PutMapping
    public EstadoDTO update(@RequestBody EstadoDTO estadoDTO){
        return estadoService.update(estadoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EstadoDTO> delete(@PathVariable("id") int id){
        estadoService.findById(id);
        return ResponseEntity.ok().build();
    }
}
