package com.curriculo.api.curriculo.entity;

import com.curriculo.api.curriculo.dto.ExpProfissionalDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ExpProfissionalEntity {
    private int id_exp_profissional;
    private String nome_empresa;
    private LocalDate data_inicio;
    private LocalDate data_termino;
    private boolean status_exp_profissional;
    private int id_curriculo;

    public ExpProfissionalEntity(ExpProfissionalDTO expProfissionalDTO) {
        BeanUtils.copyProperties(expProfissionalDTO, this);
    }
}
