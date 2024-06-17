package com.curriculo.api.curriculo.controller;

import com.curriculo.api.curriculo.dto.EnderecoDTO;
import com.curriculo.api.curriculo.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
@CrossOrigin
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public List<EnderecoDTO> findAll(){
        return enderecoService.findAll();
    }

    @GetMapping("/{id}")
    public EnderecoDTO findById(@PathVariable("id") int id){
        return enderecoService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody EnderecoDTO enderecoDTO){
        enderecoService.save(enderecoDTO);
    }

    @PutMapping
    public EnderecoDTO update(@RequestBody EnderecoDTO enderecoDTO){
        return enderecoService.update(enderecoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<EnderecoDTO> deleteById(@PathVariable("id") int id){
        enderecoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
