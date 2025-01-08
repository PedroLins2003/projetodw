package com.projetodw.demo.layers.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodw.demo.exceptions.ValidacaoException;
import com.projetodw.demo.layers.entities.Situacao;
import com.projetodw.demo.layers.repositories.RequisicaoRepository;
import com.projetodw.demo.layers.repositories.SituacaoRepository;


@Service
public class SituacaoService {
    @Autowired
    SituacaoRepository situacaoRepository;
    @Autowired
    RequisicaoRepository requisicaoRepository;

    public Situacao GetSituacao(Long idSituacao) throws ValidacaoException{
        Optional<Situacao> situacao = situacaoRepository.findById(idSituacao);

        return situacao.get();
    }

    public Situacao cadastrarSituacao(Situacao situacao) throws ValidacaoException{

        if(situacao.getId() != null) {
            throw new ValidacaoException("ID nao nulo");
        }
        
        if(situacao.getSituacao() == null){
            throw new ValidacaoException("Insira uma situacao");
        }

        if(situacao.getData() == null) {
            throw new ValidacaoException("Digite uma data");
        }

        if(situacao.getRequisicao() == null){
            throw new ValidacaoException("Informe um Id de requisicao");
        }

        if(!requisicaoRepository.existsById(situacao.getRequisicao().getId())) {
            throw new ValidacaoException("Id de Requisicao nao existe");
        }

        return situacaoRepository.save(situacao);
    }

     public Situacao atualizarSituacao(Situacao situacao) throws ValidacaoException {

        if(situacao.getId() == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<Situacao> _situacao = situacaoRepository.findById(situacao.getId());
        if(_situacao.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }

        if(situacao.getSituacao() == null){
            throw new ValidacaoException("Insira uma situacao");
        }

        if(situacao.getData() == null) {
            throw new ValidacaoException("Digite uma data");
        }

        if(situacao.getRequisicao() == null){
            throw new ValidacaoException("Informe um Id de requisicao");
        }

        if(!requisicaoRepository.existsById(situacao.getRequisicao().getId())) {
            throw new ValidacaoException("Id de Requisicao nao existe");
        }

        return situacaoRepository.save(situacao);
    }
    
    public void removerSituacao(Long idSituacao) throws ValidacaoException  {
        if(idSituacao == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<Situacao> _situacao = situacaoRepository.findById(idSituacao);
        if(_situacao.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }
        
        situacaoRepository.deleteById(idSituacao);        
    }
}
