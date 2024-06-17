package com.curriculo.api.curriculo.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UsuarioDTO {
    private int id_usuario;
    private String nome_usuario;
    private String email_usuario;
    private String senha_usuario;
    private CurriculoDTO obj_curriculo;
}
