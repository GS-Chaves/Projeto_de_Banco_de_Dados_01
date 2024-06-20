package com.curriculo.api.curriculo.controller;

import com.curriculo.api.curriculo.config.Utils;
import com.curriculo.api.curriculo.dto.ViewUsuarioCurriculoEnderecoDTO;
import com.curriculo.api.curriculo.service.UsuarioService;
import com.curriculo.api.curriculo.service.UtilsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/utils")
@CrossOrigin
public class ViewsController {

    @Autowired
    private UtilsService utilsService;

    @GetMapping("/nome/{nome}")
    public ViewUsuarioCurriculoEnderecoDTO findByNome(@PathVariable("nome") String nome){
        return utilsService.findByName(nome);
    }


}