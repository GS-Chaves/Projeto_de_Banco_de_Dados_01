package com.curriculo.api.curriculo.dto;

import com.curriculo.api.curriculo.entity.EstadoEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EstadoDTO {
    private int id_estado;
    private String nome_estado;

    public EstadoDTO(EstadoEntity estadoEntity) {
        BeanUtils.copyProperties(estadoEntity, this);
    }
}
