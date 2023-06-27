package com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.model.Tarefas;

public interface TarefaRepository extends JpaRepository <Tarefas, Long> {
    
}
