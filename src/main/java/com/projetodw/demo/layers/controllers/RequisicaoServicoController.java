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
import com.projetodw.demo.layers.entities.RequisicaoServico;
import com.projetodw.demo.layers.services.RequisicaoService;

@RestController
@RequestMapping("/requisicaoservico")
public class RequisicaoServicoController {
    @Autowired
    private RequisicaoService requisicaoService;

    @GetMapping("/{idRequisicaoServico}")
    public ResponseEntity<?> getRequisicaoServicoByRequisicaoId(@PathVariable Long idRequisicaoServico){
        try{
            requisicaoService.GetRequisicaoServicoByRequisicaoId(idRequisicaoServico);
            return ResponseEntity.status(HttpStatus.OK).body(requisicaoService.GetRequisicaoServicoByRequisicaoId(idRequisicaoServico));
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> cadastrarRequisicaoServico(@RequestBody RequisicaoServico requisicaoservico) {
        try {
            requisicaoService.cadastrarRequisicaoServico(requisicaoservico);
            return ResponseEntity.status(HttpStatus.OK).body("{cadastro concluído}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> atualizarRequisicaoServico(@RequestBody RequisicaoServico requisicaoservico) {
        try {
            requisicaoService.atualizarRequisicaoServico(requisicaoservico);
            return ResponseEntity.status(HttpStatus.OK).body("{RequisicaoServico atualizada}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{idRequisicaoServico}")
    public ResponseEntity<?> removerRequisicaoServico(@PathVariable Long idRequisicaoServico) {
        try {
            requisicaoService.removerRequisicaoServico(idRequisicaoServico);
            return ResponseEntity.status(HttpStatus.OK).body("{RequisicaoServico deletada}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

