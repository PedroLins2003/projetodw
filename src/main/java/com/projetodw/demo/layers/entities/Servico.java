package com.projetodw.demo.layers.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"requisicao_id", "servico"}))
public class Servico {

    public enum ServicoEnum {
        FORMATACAO,
        LIMPEZA,
        TROCA_HARDWARE,
        A_DEFINIR
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ServicoEnum servico;

    @Column(nullable = false)
    private String preco;

    @ManyToOne
    @JoinColumn(name = "requisicao_id", nullable = false)
    private Requisicao requisicao;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ServicoEnum getSituacao() {
        return servico;
    }

    public void setSituacao(ServicoEnum servico) {
        this.servico = servico;
    }

    public String getPreco() {
        return preco;
    }

    public void setData(String preco) {
        this.preco = preco;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }
}