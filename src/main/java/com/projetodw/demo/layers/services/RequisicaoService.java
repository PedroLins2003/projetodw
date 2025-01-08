package com.projetodw.demo.layers.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodw.demo.exceptions.ValidacaoException;

import com.projetodw.demo.layers.entities.Requisicao;
import com.projetodw.demo.layers.entities.RequisicaoEquipamento;
import com.projetodw.demo.layers.entities.RequisicaoServico;
import com.projetodw.demo.layers.repositories.ClienteRepository;
import com.projetodw.demo.layers.repositories.EquipamentoRepository;
import com.projetodw.demo.layers.repositories.RequisicaoEquipamentoRepository;
import com.projetodw.demo.layers.repositories.RequisicaoRepository;
import com.projetodw.demo.layers.repositories.RequisicaoServicoRepository;
import com.projetodw.demo.layers.repositories.ServicoRepository;


@Service
public class RequisicaoService {
    @Autowired
    ServicoRepository servicoRepository;
    EquipamentoRepository equipamentoRepository;
    ClienteRepository clienteRepository;
    RequisicaoRepository requisicaoRepository;
    RequisicaoEquipamentoRepository requisicaoequipamentoRepository;
    RequisicaoServicoRepository requisicaoservicoRepository;

    public Requisicao GetRequisicao(Long idRequisicao) throws ValidacaoException{
        Optional<Requisicao> requisicao = requisicaoRepository.findById(idRequisicao);

        return requisicao.get();
    }
    
    public Requisicao cadastrarRequisicao(Requisicao requisicao) throws ValidacaoException{
        if(requisicao.getId() != null) {
            throw new ValidacaoException("ID nao nulo");
        }

        if(requisicao.getCliente() == null) {
            throw new ValidacaoException("Id do Cliente inválido");
        }

        if(!clienteRepository.existsById(requisicao.getCliente().getId())){
            throw new ValidacaoException("Cliente com ID " + requisicao.getCliente().getId() + " não encontrado.");
        }

        if(requisicao.getTecnico() == null) {
            throw new ValidacaoException("Id do Tecnico inválido");
        }

        if(!clienteRepository.existsById(requisicao.getTecnico().getId())){
            throw new ValidacaoException("Tecnico com ID " + requisicao.getTecnico().getId() + " não encontrado.");
        }

        return requisicaoRepository.save(requisicao);
    }

    public RequisicaoEquipamento cadastrarRequisicaoEquipamento(RequisicaoEquipamento requisicaoequipamento) throws ValidacaoException{
        
        if(requisicaoequipamento.getId() != null) {
            throw new ValidacaoException("ID nao nulo");
        }

        if(requisicaoequipamento.getRequisicao() == null) {
            throw new ValidacaoException("Id do Requisicao inválido");
        }

        if(!requisicaoRepository.existsById(requisicaoequipamento.getRequisicao().getId())){
            throw new ValidacaoException("Requisicao com ID " + requisicaoequipamento.getRequisicao().getId() + " não encontrado.");
        }

        if(requisicaoequipamento.getEquipamento() == null) {
            throw new ValidacaoException("Id do Equipamento inválido");
        }

        if(!equipamentoRepository.existsById(requisicaoequipamento.getEquipamento().getId())){
            throw new ValidacaoException("Equipamento com ID " + requisicaoequipamento.getEquipamento().getId() + " não encontrado.");
        }

        if(requisicaoequipamento.getQuantidade() == null){
            throw new ValidacaoException("Adicione uma quantidade");
        }

        return requisicaoequipamentoRepository.save(requisicaoequipamento);
    }

    public RequisicaoServico cadastrarRequisicaoServico(RequisicaoServico requisicaoservico) throws ValidacaoException{
        
        if(requisicaoservico.getId() != null) {
            throw new ValidacaoException("ID nao nulo");
        }

        if(requisicaoservico.getRequisicao() == null) {
            throw new ValidacaoException("Id do Requisicao inválido");
        }

        if(!requisicaoRepository.existsById(requisicaoservico.getRequisicao().getId())){
            throw new ValidacaoException("Requisicao com ID " + requisicaoservico.getRequisicao().getId() + " não encontrado.");
        }

        if(requisicaoservico.getServico() == null) {
            throw new ValidacaoException("Id do Servico inválido");
        }

        if(!servicoRepository.existsById(requisicaoservico.getServico().getId())){
            throw new ValidacaoException("Equipamento com ID " + requisicaoservico.getServico().getId() + " não encontrado.");
        }

        if(requisicaoservico.getQuantidade() == null){
            throw new ValidacaoException("Adicione uma quantidade");
        }

        return requisicaoservicoRepository.save(requisicaoservico);
    }

    public Requisicao atualizarRequisicao(Requisicao requisicao) throws ValidacaoException {

        if(requisicao.getId() == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<Requisicao> _requisicao = requisicaoRepository.findById(requisicao.getId());
        if(_requisicao.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }

        if(requisicao.getCliente() == null) {
            throw new ValidacaoException("Id do Cliente inválido");
        }

        if(!clienteRepository.existsById(requisicao.getCliente().getId())){
            throw new ValidacaoException("Cliente com ID " + requisicao.getCliente().getId() + " não encontrado.");
        }

        if(!clienteRepository.existsById(requisicao.getTecnico().getId())){
            throw new ValidacaoException("Id do Tecnico inválido");
        }

        if(!clienteRepository.existsById(requisicao.getTecnico().getId())){
            throw new ValidacaoException("Tecnico com ID " + requisicao.getTecnico().getId() + " não encontrado.");
        }

        return requisicaoRepository.save(requisicao);
    }

    public RequisicaoEquipamento atualizarRequisicaoEquipamento(RequisicaoEquipamento requisicaoequipamento) throws ValidacaoException{
        
        if(requisicaoequipamento.getId() == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<RequisicaoEquipamento> _requisicaoequipamento = requisicaoequipamentoRepository.findById(requisicaoequipamento.getId());
        if(_requisicaoequipamento.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }

        if(requisicaoequipamento.getRequisicao() == null) {
            throw new ValidacaoException("Id do Requisicao inválido");
        }

        if(!requisicaoRepository.existsById(requisicaoequipamento.getRequisicao().getId())){
            throw new ValidacaoException("Requisicao com ID " + requisicaoequipamento.getRequisicao().getId() + " não encontrado.");
        }

        if(requisicaoequipamento.getEquipamento() == null) {
            throw new ValidacaoException("Id do Equipamento inválido");
        }

        if(!equipamentoRepository.existsById(requisicaoequipamento.getEquipamento().getId())){
            throw new ValidacaoException("Equipamento com ID " + requisicaoequipamento.getEquipamento().getId() + " não encontrado.");
        }

        if(requisicaoequipamento.getQuantidade() == null){
            throw new ValidacaoException("Adicione uma quantidade");
        }

        return requisicaoequipamentoRepository.save(requisicaoequipamento);
    }

    public RequisicaoServico atualizarRequisicaoServico(RequisicaoServico requisicaoservico) throws ValidacaoException{
        
        if(requisicaoservico.getId() == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<RequisicaoServico> _requisicaoservico = requisicaoservicoRepository.findById(requisicaoservico.getId());
        if(_requisicaoservico.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }

        if(!requisicaoRepository.existsById(requisicaoservico.getRequisicao().getId())){
            throw new ValidacaoException("Requisicao com ID " + requisicaoservico.getRequisicao().getId() + " não encontrado.");
        }

        if(requisicaoservico.getServico() == null) {
            throw new ValidacaoException("Id do Servico inválido");
        }

        if(!servicoRepository.existsById(requisicaoservico.getServico().getId())){
            throw new ValidacaoException("Equipamento com ID " + requisicaoservico.getServico().getId() + " não encontrado.");
        }

        if(requisicaoservico.getQuantidade() == null){
            throw new ValidacaoException("Adicione uma quantidade");
        }

        return requisicaoservicoRepository.save(requisicaoservico);
    }

    public void removerRequisicao(Long idRequisicao) throws ValidacaoException  {
        if(idRequisicao == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<Requisicao> _requisicao = requisicaoRepository.findById(idRequisicao);
        if(_requisicao.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }
        
        requisicaoRepository.deleteById(idRequisicao);
        requisicaoservicoRepository.deleteByRequisicaoId(idRequisicao);
        requisicaoequipamentoRepository.deleteByRequisicaoId(idRequisicao);          
    }

    public void removerRequisicaoEquipamento(Long idRequisicao) throws ValidacaoException  {
        if(idRequisicao == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<Requisicao> _requisicao = requisicaoRepository.findById(idRequisicao);
        if(_requisicao.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }
        
        requisicaoequipamentoRepository.deleteByRequisicaoId(idRequisicao);       
    }

    public void removerRequisicaoServico(Long idRequisicao) throws ValidacaoException {
        // Valida se o ID foi fornecido
        if (idRequisicao == null) {
            throw new ValidacaoException("ID é nulo");
        }
    
        // Verifica se a requisição existe
        Optional<Requisicao> _requisicao = requisicaoRepository.findById(idRequisicao);
        if (_requisicao.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }
    
        // Deleta os serviços associados à requisição com o ID fornecido
        requisicaoservicoRepository.deleteByRequisicaoId(idRequisicao);        
    }
    

}
