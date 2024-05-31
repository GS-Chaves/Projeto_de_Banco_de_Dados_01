package com.curriculo.api.curriculo.entity;

import com.curriculo.api.curriculo.dto.UsuarioDTO;
import lombok.*;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UsuarioEntity {
    private int id_usuario;
    private String nome_usuario;
    private String email_usuario;
    private String senha_usuario;

    public UsuarioEntity(UsuarioDTO usuarioDTO) {
        BeanUtils.copyProperties(usuarioDTO, this);
    }
}
