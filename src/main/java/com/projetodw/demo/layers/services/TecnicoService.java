package com.projetodw.demo.layers.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodw.demo.exceptions.ValidacaoException;
import com.projetodw.demo.layers.entities.Tecnico;
import com.projetodw.demo.layers.repositories.TecnicoRepository;

@Service
public class TecnicoService {
    @Autowired
    TecnicoRepository tecnicoRepository;

    public Tecnico cadastrarTecnico(Tecnico tecnico) throws ValidacaoException{
        if(tecnico.getId() != null) {
            throw new ValidacaoException("ID nao nulo");
        }

        if(tecnico.getNome() == null || tecnico.getNome().isBlank()) {
            throw new ValidacaoException("Nome inválido");
        }

        if(tecnico.getEspecializacao() == null || tecnico.getNome().isBlank()) {
            throw new ValidacaoException("ID nao nulo");
        }

        return tecnicoRepository.save(tecnico);
    }

}
