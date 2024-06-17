package com.curriculo.api.curriculo.controller;

import com.curriculo.api.curriculo.dto.CurriculoDTO;
import com.curriculo.api.curriculo.service.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curriculo")
@CrossOrigin
public class CurriculoController {

    @Autowired
    private CurriculoService curriculoService;

    @GetMapping
    public List<CurriculoDTO> findAll(){
        return curriculoService.findAll();
    }

    @GetMapping("/{nome}")
    public List<CurriculoDTO> findByNome(@PathVariable("nome") String nome){
        return curriculoService.findByNome(nome);
    }

    @GetMapping("/{id}")
    public CurriculoDTO findById(@PathVariable("id") int id){
        return curriculoService.findById(id);
    }

    @PostMapping
    public void save(@RequestBody CurriculoDTO curriculoDTO){
        curriculoService.save(curriculoDTO);
    }

    @PutMapping
    public CurriculoDTO update(@RequestBody CurriculoDTO curriculoDTO){
        return curriculoService.update(curriculoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CurriculoDTO> deleteById(@PathVariable("id") int id) {
        curriculoService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
