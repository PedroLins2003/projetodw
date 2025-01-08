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
import com.projetodw.demo.layers.entities.RequisicaoEquipamento;
import com.projetodw.demo.layers.services.RequisicaoService;

@RestController
@RequestMapping("/requisicaoequipamento")
public class RequisicaoEquipamentoController {
    @Autowired
    private RequisicaoService requisicaoService;

    @GetMapping("/{idRequisicao}")
    public ResponseEntity<?> GetRequisicaoEquipamentoByRequisicaoId(@PathVariable Long idRequisicao){
        try{
            requisicaoService.GetRequisicaoEquipamentoByRequisicaoId(idRequisicao);
            return ResponseEntity.status(HttpStatus.OK).body(requisicaoService.GetRequisicaoEquipamentoByRequisicaoId(idRequisicao));
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
    
    @PostMapping
    public ResponseEntity<?> cadastrarRequisicaoEquipamento(@RequestBody RequisicaoEquipamento requisicaoequipamento) {
        try {
            requisicaoService.cadastrarRequisicaoEquipamento(requisicaoequipamento);
            return ResponseEntity.status(HttpStatus.OK).body("{cadastro concluído}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> atualizarRequisicaoEquipamento(@RequestBody RequisicaoEquipamento requisicaoequipamento) {
        try {
            requisicaoService.atualizarRequisicaoEquipamento(requisicaoequipamento);
            return ResponseEntity.status(HttpStatus.OK).body("{RequisicaoEquipamento atualizado}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{idRequisicaoEquipamento}")
    public ResponseEntity<?> removerRequisicaoEquipamento(@PathVariable Long idRequisicaoEquipamento) {
        try {
            requisicaoService.removerRequisicao(idRequisicaoEquipamento);
            return ResponseEntity.status(HttpStatus.OK).body("{RequisicaoEquipamento deletada}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}


