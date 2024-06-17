package com.curriculo.api.curriculo.controller;

import com.curriculo.api.curriculo.dto.FormacaoDTO;
import com.curriculo.api.curriculo.service.FormacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/formacao")
@CrossOrigin
public class FormacaoController {

    @Autowired
    private FormacaoService formacaoService;

    @GetMapping
    public List<FormacaoDTO> findAll(){
        return formacaoService.findAll();
    }

    @GetMapping("/{id}")
    public FormacaoDTO findById(@PathVariable("id") int id){
        return formacaoService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody FormacaoDTO formacao){
        formacaoService.save(formacao);
    }

    @PutMapping
    public FormacaoDTO update(@RequestBody FormacaoDTO formacao){
        return formacaoService.update(formacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FormacaoDTO> deleteById(@PathVariable("id") int id){
        formacaoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
