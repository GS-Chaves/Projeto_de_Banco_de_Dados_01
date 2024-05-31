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
    private int id_bairro;
    private int id_cidade;
    private int id_estado;
    private int id_pais;

    public EnderecoDTO(EnderecoEntity enderecoEntity){
        BeanUtils.copyProperties(enderecoEntity, this);
    }
}
