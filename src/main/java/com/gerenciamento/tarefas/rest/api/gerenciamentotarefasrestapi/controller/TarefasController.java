package com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.controller;


import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
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

import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.model.Tarefas;
import com.gerenciamento.tarefas.rest.api.gerenciamentotarefasrestapi.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
@Secured({"ROLE_ADMIN"})
public class TarefasController {
    
    
    @PostMapping
     public ResponseEntity<Object> cadastrarTarefa(@RequestBody Tarefas tarefas) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefas));
    }

    
   @GetMapping
   public ResponseEntity<Page<Tarefas>> listarTarefas(@PageableDefault(size = 5, page = 0, sort = "titulo")Pageable paginacao){
       return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.findAll(paginacao));
   }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obterTarefaPeloId(@PathVariable("id") long id) {
        return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.findById(id));
    }

    @PutMapping
    public ResponseEntity<Tarefas> atualizarTarefas(@RequestBody Tarefas tarefas){
        return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.save(tarefas));
    }

    @DeleteMapping(value = "/{id}")
    public void deletarTarefas(@PathVariable("id")long id){
        tarefaRepository.deleteById(id);
    }


    
    
    @Autowired
    private TarefaRepository tarefaRepository;


}