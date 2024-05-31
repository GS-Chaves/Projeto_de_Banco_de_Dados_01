package com.curriculo.api.curriculo.dto;

import com.curriculo.api.curriculo.entity.BairroEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BairroDTO {
    private int id_bairro;
    private String nome_bairro;

    public BairroDTO(BairroEntity bairroEntity){
        BeanUtils.copyProperties(bairroEntity, this);
    }
}
