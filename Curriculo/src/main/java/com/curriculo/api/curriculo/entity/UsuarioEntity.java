package com.curriculo.api.curriculo.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UsuarioEntity {
    private Long id_usuario;
    private String nome_usuario;
    private String email_usuario;
    private String senha_usuario;
}
