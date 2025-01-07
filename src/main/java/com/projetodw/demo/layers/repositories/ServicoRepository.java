package com.projetodw.demo.layers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetodw.demo.layers.entities.Servico;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long> {

}

