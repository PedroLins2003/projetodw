package com.projetodw.demo.layers.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodw.demo.exceptions.ValidacaoException;
import com.projetodw.demo.layers.entities.Equipamento;
import com.projetodw.demo.layers.repositories.EquipamentoRepository;

@Service
public class EquipamentoService {
    @Autowired
    EquipamentoRepository equipamentoRepository;
    
    public Equipamento cadastrarEquipamento(Equipamento equipamento) throws ValidacaoException{
        
        if(equipamento.getId() != null) {
            throw new ValidacaoException("ID nao nulo");
        }
        
        return equipamentoRepository.save(equipamento);
    }
        
}

