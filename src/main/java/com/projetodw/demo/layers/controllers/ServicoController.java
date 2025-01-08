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
import com.projetodw.demo.layers.entities.Servico;
import com.projetodw.demo.layers.services.ServicoService;

@RestController
@RequestMapping("/servico")
public class ServicoController{ 
    
    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<?> cadastrarServico(@RequestBody Servico servico) {
        try {
            servicoService.cadastrarServico(servico);
            return ResponseEntity.status(HttpStatus.OK).body("{cadastro concluído}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> atualizarServico(@RequestBody Servico servico) {
        try {
            servicoService.atualizarServico(servico);
            return ResponseEntity.status(HttpStatus.OK).body("{Servico atualizado}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @DeleteMapping("/{idServico}")
    public ResponseEntity<?> removerServico(@PathVariable Long idServico) {
        try {
            servicoService.removerServico(idServico);
            return ResponseEntity.status(HttpStatus.OK).body("{Servico deletado}");
        } catch (ValidacaoException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}