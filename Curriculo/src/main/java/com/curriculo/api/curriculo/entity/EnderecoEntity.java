package com.curriculo.api.curriculo.entity;

import com.curriculo.api.curriculo.dto.EnderecoDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class EnderecoEntity {
    private int id_endereco;
    private String rua;
    private int id_bairro;
    private int id_cidade;
    private int id_estado;
    private int id_pais;

    public EnderecoEntity(EnderecoDTO enderecoDTO){
        BeanUtils.copyProperties(enderecoDTO, this);
    }
}
