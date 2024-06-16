package com.curriculo.api.curriculo.controller;

import com.curriculo.api.curriculo.dto.CurriculoDTO;
import com.curriculo.api.curriculo.service.CurriculoService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void save(@RequestBody CurriculoDTO curriculoDTO){
        curriculoService.save(curriculoDTO);
    }
}
