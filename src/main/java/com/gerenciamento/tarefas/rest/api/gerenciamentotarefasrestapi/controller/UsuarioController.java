package com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.controller;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.model.Usuario;
import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.repository.UsuarioRepository;
import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.service.AuthenticationService;



@RestController
@RequestMapping(value = "/api/v1/usuarios", produces = "application/json")
public class UsuarioController {

    @PostMapping
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Object> salvarInformacoesUsuario(@RequestBody Usuario usuario) {
        long idUsuario = usuario.getIdUsuario();

        if (idUsuario == 0) {
            UserDetails usuarioBD = usuarioRepository.findByEmail(usuario.getEmail());

            if (Objects.nonNull(usuarioBD)) {
                return ResponseEntity.status(HttpStatus.ALREADY_REPORTED)
                        .body("Já existe um usuário cadastrado com este e-mail!");
            }

            String senha = usuario.getSenha();

            BCryptPasswordEncoder encoder = authenticationService.getPasswordEncoder();

            usuario.setSenha(encoder.encode(senha));
        }

        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
    }

    @GetMapping
    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    public ResponseEntity<Object> obterUsuarios(
            @PageableDefault(size = 10, page = 0, sort = { "nome" }, direction = Direction.ASC) Pageable paging) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findAll(paging));
    }

    @GetMapping(value = "/{id}")
    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    public ResponseEntity<Object> obterUsuarioPeloId(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findById(id));
    }

    @DeleteMapping(value = "/{id}")
    @Secured("ROLE_ADMIN")
    public ResponseEntity<Object> deletarUsuario(@PathVariable("id") long id) {
        usuarioRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body("Usuário deletada com sucesso!");
    }

    @GetMapping(value = "/nome/{nome}")
    @Secured({ "ROLE_ADMIN", "ROLE_USER" })
    public ResponseEntity<Object> obterUsuarioPeloNome(
            @PathVariable("nome") String nome,
            @PageableDefault(size = 10, page = 0, sort = { "nome" }, direction = Direction.ASC) Pageable paging) {
        return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.findByNomeLike(paging, nome + "%"));
    }

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UsuarioRepository usuarioRepository;

}

