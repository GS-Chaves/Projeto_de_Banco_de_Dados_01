package com.curriculo.api.curriculo.entity;

import lombok.*;

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
}
