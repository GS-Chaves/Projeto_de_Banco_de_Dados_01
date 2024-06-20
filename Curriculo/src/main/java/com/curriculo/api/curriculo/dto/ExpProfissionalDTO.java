package com.curriculo.api.curriculo.dto;

import com.curriculo.api.curriculo.entity.ExpProfissionalEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ExpProfissionalDTO {
    private int id_exp_profissional;
    private String nome_empresa;
    private LocalDate data_inicio;
    private LocalDate data_termino;
    private boolean status_exp_profissional;
    private int id_curriculo;
    private int fk_id_curriculo;

    public ExpProfissionalDTO(ExpProfissionalEntity expProfissionalEntity) {
        BeanUtils.copyProperties(expProfissionalEntity, this);
    }
}
