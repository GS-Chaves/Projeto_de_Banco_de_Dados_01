package com.curriculo.api.curriculo.dto;

import com.curriculo.api.curriculo.entity.CidadeEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CidadeDTO {
    private int id_cidade;
    private String nome_cidade;
    private int fk_id_estado;
    public CidadeDTO(CidadeEntity cidadeEntity){
        BeanUtils.copyProperties(cidadeEntity, this);
    }
}
