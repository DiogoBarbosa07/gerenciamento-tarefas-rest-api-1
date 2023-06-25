package com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tb_perfis_usuario")
public class PerfilUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPerfilUsuario;

    @Column(name = "nome", unique = true, nullable = false)
    private String nome;

    public PerfilUsuario(long idPerfilUsuario) {
        this.idPerfilUsuario = idPerfilUsuario;
    }

}

