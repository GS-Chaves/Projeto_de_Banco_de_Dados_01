package com.curriculo.api.curriculo.entity;

import com.curriculo.api.curriculo.dto.PaisDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaisEntity {
    private int id_pais;
    private String nome_pais;

    public PaisEntity(PaisDTO paisDTO){
        BeanUtils.copyProperties(paisDTO, this);
    }
}
