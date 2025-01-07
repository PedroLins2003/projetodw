package com.projetodw.demo.layers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodw.demo.exceptions.ValidacaoException;
import com.projetodw.demo.layers.entities.Situacao;
import com.projetodw.demo.layers.repositories.SituacaoRepository;

@Service
public class SituacaoService {
    @Autowired
    SituacaoRepository situacaoRepository;

    public Situacao cadastrarSituacao(Situacao situacao) throws ValidacaoException{
        return situacaoRepository.save(situacao);
    }

}
