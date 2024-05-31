package com.curriculo.api.curriculo.dto;

import com.curriculo.api.curriculo.entity.PaisEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class PaisDTO {
    private int id_pais;
    private String nome_pais;

    public PaisDTO(PaisEntity paisEntity){
        BeanUtils.copyProperties(paisEntity, this);
    }
}
