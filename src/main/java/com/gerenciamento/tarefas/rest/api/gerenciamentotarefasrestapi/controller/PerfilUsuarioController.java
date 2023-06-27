package com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.model.PerfilUsuario;
import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.repository.PerfilUsuarioRepository;




@Secured("ROLE_ADMIN")
@RestController
@RequestMapping(value = "/api/v1/usuarios/perfis", produces = "application/json")
public class PerfilUsuarioController {

    @PostMapping
    public ResponseEntity<Object> cadastrarPerfilUsuario(@RequestBody PerfilUsuario perfilUsuario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(perfilUsuarioRepository.save(perfilUsuario));
    }

    @GetMapping
    public ResponseEntity<Object> obterPerfisUsuario() {
        return ResponseEntity.status(HttpStatus.OK).body(perfilUsuarioRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> obterPerfilUsuarioPeloId(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(perfilUsuarioRepository.findById(id));
    }

    @PutMapping
    public ResponseEntity<Object> atualizarPerfilUsuario(@RequestBody PerfilUsuario perfilUsuario) {
        return ResponseEntity.status(HttpStatus.FOUND).body(perfilUsuarioRepository.save(perfilUsuario));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletarTipoUsuario(@PathVariable("id") long id) {
        perfilUsuarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;

}
