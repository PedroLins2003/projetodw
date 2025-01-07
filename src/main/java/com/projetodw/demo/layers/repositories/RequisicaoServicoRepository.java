package com.projetodw.demo.layers.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetodw.demo.layers.entities.RequisicaoServico;

@Repository
public interface RequisicaoServicoRepository extends JpaRepository<RequisicaoServico, Long> {

}
