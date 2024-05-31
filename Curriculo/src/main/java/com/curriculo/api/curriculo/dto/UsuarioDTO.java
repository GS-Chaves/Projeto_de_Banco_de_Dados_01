package com.curriculo.api.curriculo.dto;

import com.curriculo.api.curriculo.entity.UsuarioEntity;
import lombok.*;
import org.springframework.beans.BeanUtils;

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

    public UsuarioDTO(UsuarioEntity usuarioEntity){
        BeanUtils.copyProperties(usuarioEntity, this);
    }
}
