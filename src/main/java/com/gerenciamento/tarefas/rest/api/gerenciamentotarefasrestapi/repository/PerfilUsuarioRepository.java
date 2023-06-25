package com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.model.PerfilUsuario;


public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuario, Long> {

}