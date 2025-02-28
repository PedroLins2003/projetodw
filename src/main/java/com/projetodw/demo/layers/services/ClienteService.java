package com.projetodw.demo.layers.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetodw.demo.exceptions.ValidacaoException;
import com.projetodw.demo.layers.entities.Cliente;
import com.projetodw.demo.layers.repositories.ClienteRepository;
import com.projetodw.demo.utils.CPFValidator;
import com.projetodw.demo.utils.NTelefoneValidator;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente GetCliente(Long idCliente) throws ValidacaoException{
        Optional<Cliente> cliente = clienteRepository.findById(idCliente);

        return cliente.get();
    }

    public Cliente cadastrarCliente(Cliente cliente) throws ValidacaoException {

        if(cliente.getId() != null) {
            throw new ValidacaoException("ID nao nulo");
        }
        
        if(clienteRepository.existsByCpf(cliente.getCpf())){
            throw new ValidacaoException("CPF já registrado");
        }

        if(!CPFValidator.isValidCPF(cliente.getCpf())) {
            throw new ValidacaoException("CPF inválido");
        }

        if(cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new ValidacaoException("Nome inválido");
        }

        if(!NTelefoneValidator.isValidNtelefone(cliente.getTelefone())){
            throw new ValidacaoException("Numero de telefone inválido");
        }

        if(clienteRepository.existsByTelefone(cliente.getTelefone())){
            throw new ValidacaoException("Telefone já registrado");
        }

        return clienteRepository.save(cliente);
    } 

    public Cliente atualizarCliente(Cliente cliente) throws ValidacaoException {

        if(cliente.getId() == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<Cliente> _cliente = clienteRepository.findById(cliente.getId());
        if(_cliente.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }

        if(!CPFValidator.isValidCPF(cliente.getCpf())) {
            throw new ValidacaoException("CPF inválido");
        }

        if(cliente.getNome() == null || cliente.getNome().isBlank()) {
            throw new ValidacaoException("Nome inválido");
        }

        if(!NTelefoneValidator.isValidNtelefone(cliente.getTelefone())){
            throw new ValidacaoException("Numero de telefone inválido");
        }

        if(clienteRepository.existsByTelefone(cliente.getTelefone())){
            throw new ValidacaoException("Telefone já registrado");
        }

        return clienteRepository.save(cliente);
    }

    public void removerCliente(Long idCliente) throws ValidacaoException  {
        if(idCliente == null) {
            throw new ValidacaoException("ID é nulo");
        }

        Optional<Cliente> _cliente = clienteRepository.findById(idCliente);
        if(_cliente.isEmpty()) {
            throw new ValidacaoException("ID não existe");
        }
        
        clienteRepository.deleteById(idCliente);        
    }
}
