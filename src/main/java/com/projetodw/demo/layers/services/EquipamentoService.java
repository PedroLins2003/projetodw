package com.projetodw.demo.layers.services;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodw.demo.exceptions.ValidacaoException;
import com.projetodw.demo.layers.entities.Equipamento;
import com.projetodw.demo.layers.repositories.EquipamentoRepository;


@Service
public class EquipamentoService {
    @Autowired
    EquipamentoRepository equipamentoRepository;

    public Equipamento GetEquipamento(Long idEquipamento) throws ValidacaoException{
        Optional<Equipamento> equipamento = equipamentoRepository.findById(idEquipamento);

        return equipamento.get();
    }
    
    
    public Equipamento cadastrarEquipamento(Equipamento equipamento) throws ValidacaoException{
        
        if(equipamento.getId() != null) {
            throw new ValidacaoException("ID nao nulo");
        }
    
        if (equipamento == null || equipamento.getTipo() == null) {
            throw new ValidacaoException("Insira um tipo de equipamento");
        }
    
        return equipamentoRepository.save(equipamento);
    }

    public Equipamento atualizarEquipamento(Equipamento equipamento) throws ValidacaoException {

        if(equipamento.getId() == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<Equipamento> _equipamento = equipamentoRepository.findById(equipamento.getId());
        if(_equipamento.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }

        return equipamentoRepository.save(equipamento);
    }

    public void removerEquipamento(Long idEquipamento) throws ValidacaoException  {
        if(idEquipamento == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<Equipamento> _equipamento = equipamentoRepository.findById(idEquipamento);
        if(_equipamento.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }
        
        equipamentoRepository.deleteById(idEquipamento);        
    }
        
}

