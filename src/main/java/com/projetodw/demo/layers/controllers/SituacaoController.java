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
import com.projetodw.demo.layers.entities.Situacao;
import com.projetodw.demo.layers.services.SituacaoService;

@RestController
@RequestMapping("/situacao")
public class SituacaoController {

    @Autowired
    private SituacaoService situacaoService;

    @GetMapping("/{idSituacao}")
    public ResponseEntity<?> getSituacao(@PathVariable Long idSituacao){
        try{
            situacaoService.GetSituacao(idSituacao);
            return ResponseEntity.status(HttpStatus.OK).body(situacaoService.GetSituacao(idSituacao));
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrarSituacao(@RequestBody Situacao situacao) {
        try {
            situacaoService.cadastrarSituacao(situacao);
            return ResponseEntity.status(HttpStatus.OK).body("{cadastro concluído}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> atualizarSituacao(@RequestBody Situacao situacao) {
        try {
            situacaoService.atualizarSituacao(situacao);
            return ResponseEntity.status(HttpStatus.OK).body("{}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{idSituacao}")
    public ResponseEntity<?> removerSituacao(@PathVariable Long idSituacao) {
        try {
            situacaoService.removerSituacao(idSituacao);
            return ResponseEntity.status(HttpStatus.OK).body("{}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
