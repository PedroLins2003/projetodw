package com.projetodw.demo.layers.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetodw.demo.layers.entities.RequisicaoEquipamento;

@Repository
public interface RequisicaoEquipamentoRepository extends JpaRepository<RequisicaoEquipamento, Long> {

    void deleteByRequisicaoId(Long idRequisicao);

    List<RequisicaoEquipamento> findByRequisicaoId(Long requisicaoId);

}
