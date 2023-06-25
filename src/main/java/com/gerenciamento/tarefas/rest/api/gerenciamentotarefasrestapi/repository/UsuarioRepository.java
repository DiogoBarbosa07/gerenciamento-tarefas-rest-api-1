package com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findByNomeLike(Pageable pageable, String nome);

    Usuario findByEmail(String email);

    boolean existsByEmail(String email);

}
