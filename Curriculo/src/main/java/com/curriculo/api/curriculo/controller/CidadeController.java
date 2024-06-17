package com.curriculo.api.curriculo.controller;

import com.curriculo.api.curriculo.dto.CidadeDTO;
import com.curriculo.api.curriculo.dto.UsuarioDTO;
import com.curriculo.api.curriculo.repository.CidadeRepository;
import com.curriculo.api.curriculo.service.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/cidade")
@CrossOrigin
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public List<CidadeDTO> findAll(){
        return cidadeService.findAll();
    }

    @GetMapping("/{id}")
    public CidadeDTO findById(@PathVariable("id") int id){
        return cidadeService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody CidadeDTO cidadeDTO){
        cidadeService.save(cidadeDTO);
    }

    @PutMapping
    public CidadeDTO update(@RequestBody CidadeDTO cidadeDTO){
        return cidadeService.update(cidadeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CidadeDTO> deleteById(@PathVariable("id") int id){
        cidadeService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
