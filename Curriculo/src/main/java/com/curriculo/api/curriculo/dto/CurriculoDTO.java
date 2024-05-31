package com.curriculo.api.curriculo.dto;

import com.curriculo.api.curriculo.entity.CurriculoEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CurriculoDTO {
    private int id_curriculo;
    private String url_foto_pessoal;
    private int cpf;
    private LocalDate data_nascimento;
    private int id_usuario;

    public CurriculoDTO(CurriculoEntity curriculoEntity) {
        BeanUtils.copyProperties(curriculoEntity, this);
    }
}
