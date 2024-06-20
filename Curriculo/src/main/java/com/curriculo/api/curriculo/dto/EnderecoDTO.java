package com.curriculo.api.curriculo.dto;

import com.curriculo.api.curriculo.entity.EnderecoEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EnderecoDTO {
    private int id_endereco;
    private String rua;
    private String num;
    private int id_bairro;

    public EnderecoDTO(EnderecoEntity enderecoEntity){
        BeanUtils.copyProperties(enderecoEntity, this);
    }
}
