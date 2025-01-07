package com.projetodw.demo.layers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetodw.demo.layers.entities.Situacao;

@Repository
public interface SituacaoRepository extends JpaRepository<Situacao, Long> {

}

