package com.projetodw.demo.layers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetodw.demo.exceptions.ValidacaoException;
import com.projetodw.demo.layers.entities.Requisicao;
import com.projetodw.demo.layers.services.RequisicaoService;

@RestController
@RequestMapping("/requisicao")
public class RequisicaoController {
    @Autowired
    private RequisicaoService requisicaoService;

    @GetMapping("/{idRequisicao}")
    public ResponseEntity<?> getRequisicao(@PathVariable Long idRequisicao){
        try{
            requisicaoService.GetRequisicao(idRequisicao);
            return ResponseEntity.status(HttpStatus.OK).body(requisicaoService.GetRequisicao(idRequisicao));
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrarRequisicao(@RequestBody Requisicao requisicao) {
        try {
            requisicaoService.cadastrarRequisicao(requisicao);
            return ResponseEntity.status(HttpStatus.OK).body("{cadastro concluído}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> atualizarRequisicao(@RequestBody Requisicao requisicao) {
        try {
            requisicaoService.atualizarRequisicao(requisicao);
            return ResponseEntity.status(HttpStatus.OK).body("{Requisicao atualizado}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{idRequisicao}")
    public ResponseEntity<?> removerRequisicao(@PathVariable Long idRequisicao) {
        try {
            requisicaoService.removerRequisicao(idRequisicao);
            return ResponseEntity.status(HttpStatus.OK).body("{Requisicao deletada}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

