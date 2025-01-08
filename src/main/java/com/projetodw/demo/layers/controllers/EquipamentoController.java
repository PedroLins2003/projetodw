package com.projetodw.demo.layers.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetodw.demo.exceptions.ValidacaoException;
import com.projetodw.demo.layers.entities.Equipamento;
import com.projetodw.demo.layers.services.EquipamentoService;

@RestController
@RequestMapping("/equipamento")
public class EquipamentoController {
    @Autowired
    private EquipamentoService equipamentoService;

    // Endpoint para cadastrar um novo cliente
    @PostMapping
    public ResponseEntity<?> cadastrarEquipamento(@RequestBody Equipamento equipamento) {
        try {
            equipamentoService.cadastrarEquipamento(equipamento);
            return ResponseEntity.status(HttpStatus.OK).body("{cadastro concluído}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> atualizarEquipamento(@RequestBody Equipamento equipamento) {
        try {
            equipamentoService.atualizarEquipamento(equipamento);
            return ResponseEntity.status(HttpStatus.OK).body("{Equipamento atualizado}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{idEquipamento}")
    public ResponseEntity<?> removerEquipamento(@PathVariable Long idEquipamento) {
        try {
            equipamentoService.removerEquipamento(idEquipamento);
            return ResponseEntity.status(HttpStatus.OK).body("{Equipamento deletado}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
