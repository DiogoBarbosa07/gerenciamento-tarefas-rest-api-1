package com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.model;

import java.util.Date;

import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.constants.Status;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_tarefas")
public class Tarefas {
    
    private String titulo;
    private String descricao;
    private Date dataDeCriacao;
    private Status status;


}
