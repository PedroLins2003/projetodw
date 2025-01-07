package com.projetodw.demo.layers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodw.demo.exceptions.ValidacaoException;
import com.projetodw.demo.layers.entities.Requisicao;

import com.projetodw.demo.layers.repositories.RequisicaoEquipamentoRepository;
import com.projetodw.demo.layers.repositories.RequisicaoRepository;
import com.projetodw.demo.layers.repositories.RequisicaoServicoRepository;


@Service
public class RequisicaoService {
    @Autowired
    RequisicaoRepository requisicaoRepository;
    RequisicaoEquipamentoRepository requisicaoequipamentoRepository;
    RequisicaoServicoRepository requisicaoservicoRepository;
    
    public Requisicao cadastrarRequisicao(Requisicao requisicao) throws ValidacaoException{
        if(requisicao.getId() != null) {
            throw new ValidacaoException("ID nao nulo");
        }

        if(requisicao.getCliente() == null || requisicao.getCliente().getNome().isBlank()) {
            throw new ValidacaoException("Nome inválido");
        }

        return requisicaoRepository.save(requisicao);
    }

}
