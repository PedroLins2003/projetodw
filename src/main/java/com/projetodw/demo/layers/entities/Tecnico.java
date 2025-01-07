package com.projetodw.demo.layers.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Tecnico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tecnico", nullable = false)
    private String tecnico;

    @Column(name = "especializacao")
    private String especializacao;

    @OneToMany(mappedBy = "tecnico")
    private List<Requisicao> requisicoes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return tecnico;
    }

    public void setNome(String tecnico) {
        this.tecnico = tecnico;
    }

    public String getEspecializacao() {
        return especializacao;
    }

    public void setEspecializacao(String especializacao) {
        this.especializacao = especializacao;
    }

    public List<Requisicao> getRequisicoes() {
        return requisicoes;
    }

    public void setRequisicoes(List<Requisicao> requisicoes) {
        this.requisicoes = requisicoes;
    }
}