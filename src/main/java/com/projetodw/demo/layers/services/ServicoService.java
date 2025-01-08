package com.projetodw.demo.layers.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodw.demo.exceptions.ValidacaoException;
import com.projetodw.demo.layers.entities.Servico;
import com.projetodw.demo.layers.repositories.ServicoRepository;

@Service
public class ServicoService {
    @Autowired
    ServicoRepository servicoRepository;

    public Servico GetServico(Long idServico) throws ValidacaoException{
        Optional<Servico> servico = servicoRepository.findById(idServico);

        return servico.get();
    }

    public Servico cadastrarServico(Servico servico) throws ValidacaoException{

        if(servico.getId() != null) {
            throw new ValidacaoException("ID nao nulo");
        }

        if(servico.getServico() == null){
            throw new ValidacaoException("insira um servico");
        }

        if(servico.getPreco() == null){
            throw new ValidacaoException("Insira um preço");
        }

        return servicoRepository.save(servico);
    }

    public Servico atualizarServico(Servico servico) throws ValidacaoException{

        if(servico.getId() == null) {
            throw new ValidacaoException("ID nulo");
        }

        if(servico.getPreco() == null){
            throw new ValidacaoException("Insira um preço");
        }

        if(servico.getServico() == null){
            throw new ValidacaoException("insira um servico");
        }

        Optional<Servico> _servico = servicoRepository.findById(servico.getId());
        if(_servico.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }

        return servicoRepository.save(servico);
    }

    public void removerServico(Long idServico) throws ValidacaoException  {
        if(idServico == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<Servico> _servico = servicoRepository.findById(idServico);
        if(_servico.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }
        
        servicoRepository.deleteById(idServico);        
    }

}
