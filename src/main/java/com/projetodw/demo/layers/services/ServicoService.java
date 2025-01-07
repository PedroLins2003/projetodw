package com.projetodw.demo.layers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodw.demo.exceptions.ValidacaoException;
import com.projetodw.demo.layers.entities.Servico;
import com.projetodw.demo.layers.repositories.ServicoRepository;

@Service
public class ServicoService {
    @Autowired
    ServicoRepository servicoRepository;

    public Servico cadastrarServico(Servico servico) throws ValidacaoException{
        return servicoRepository.save(servico);
    }

}
