package com.curriculo.api.curriculo.entity;

import com.curriculo.api.curriculo.dto.CidadeDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CidadeEntity {
    private int id_cidade;
    private String nome_cidade;

    public CidadeEntity(CidadeDTO cidadeDTO){
        BeanUtils.copyProperties(cidadeDTO, this);
    }
}
