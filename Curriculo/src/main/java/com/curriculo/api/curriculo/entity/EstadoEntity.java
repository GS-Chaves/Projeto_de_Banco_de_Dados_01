package com.curriculo.api.curriculo.entity;

import com.curriculo.api.curriculo.dto.EstadoDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EstadoEntity {
    private int id_estado;
    private String nome_estado;

    public EstadoEntity(EstadoDTO estadoDTO){
        BeanUtils.copyProperties(estadoDTO, this);
    }
}
