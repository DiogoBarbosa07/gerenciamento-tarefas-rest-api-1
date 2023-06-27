package com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.model;

import java.util.Date;

import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.constants.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tb_tarefas")
public class Tarefas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTarefas;
    
    private String titulo;
    private String descricao;
    private Date dataDeCriacao;
    private Status status;


}
