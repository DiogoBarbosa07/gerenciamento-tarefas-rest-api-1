package com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.dto;


import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.model.PerfilUsuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    private String nome;
    private String sobrenome;
    private String email;
    private String token;
    private PerfilUsuario perfilUsuario;

}
