package com.projetodw.demo.layers.services;

import java.util.Arrays;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodw.demo.exceptions.ValidacaoException;
import com.projetodw.demo.layers.entities.Equipamento;
import com.projetodw.demo.layers.entities.Equipamento.MarcaEnum;
import com.projetodw.demo.layers.entities.Equipamento.TipoEnum;
import com.projetodw.demo.layers.repositories.EquipamentoRepository;


@Service
public class EquipamentoService {
    @Autowired
    EquipamentoRepository equipamentoRepository;

    public void validarTipoEquipamento(Equipamento equipamento) throws ValidacaoException {
        boolean tipoValido = Arrays.stream(TipoEnum.values())
                .anyMatch(tipo -> tipo == equipamento.getTipo());
    
        if (!tipoValido) {
            throw new ValidacaoException("Tipo não listado");
        }
    }

    public void validarMarcaEquipamento(Equipamento equipamento) throws ValidacaoException {
        boolean tipoValido = Arrays.stream(MarcaEnum.values())
                .anyMatch(tipo -> tipo == equipamento.getMarca());
    
        if (!tipoValido) {
            throw new ValidacaoException("Tipo não listado");
        }
    }
    
    
    public Equipamento cadastrarEquipamento(Equipamento equipamento) throws ValidacaoException{
        
        if(equipamento.getId() != null) {
            throw new ValidacaoException("ID nao nulo");
        }

        if(equipamento.getTipo() == null) {
            throw new ValidacaoException("Informe o tipo do equipamento");
        }
    
        validarTipoEquipamento(equipamento);

        validarMarcaEquipamento(equipamento);
        
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

        validarTipoEquipamento(equipamento);

        validarMarcaEquipamento(equipamento);

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

