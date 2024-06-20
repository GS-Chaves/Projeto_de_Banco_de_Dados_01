package com.curriculo.api.curriculo.controller;

import com.curriculo.api.curriculo.dto.UsuarioDTO;
import com.curriculo.api.curriculo.dto.ViewUsuarioCurriculoEnderecoDTO;
import com.curriculo.api.curriculo.dto.ViewUsuarioSemSenhaDTO;
import com.curriculo.api.curriculo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
@CrossOrigin
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<ViewUsuarioSemSenhaDTO> findAll(){
        return usuarioService.findAll();
    }

    @GetMapping("/id/{id}")
    public UsuarioDTO findById(@PathVariable("id") int id){
        return usuarioService.findById(id);
    }

    @GetMapping("/nome/{nome}")
    public UsuarioDTO findByNome(@PathVariable("nome") String nome){
        return usuarioService.findByNome(nome);
    }



    @PostMapping
    public void save(@RequestBody UsuarioDTO usuarioDTO){
        usuarioService.save(usuarioDTO);
    }

    @PutMapping
    public UsuarioDTO update(@RequestBody UsuarioDTO usuarioDTO){
        return usuarioService.update(usuarioDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTO> deleteById(@PathVariable("id") int id){
        usuarioService.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
