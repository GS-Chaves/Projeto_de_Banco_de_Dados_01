package com.curriculo.api.curriculo.entity;

import com.curriculo.api.curriculo.dto.BairroDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BairroEntity {
    private int id_bairro;
    private String nome_bairro;
    private int fk_id_cidade;

    public BairroEntity(BairroDTO bairroDTO){
        BeanUtils.copyProperties(bairroDTO, this);
    }
}
