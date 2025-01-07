package com.projetodw.demo.layers.entities;

import java.util.Date;

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
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"requisicao_id", "situacao"}))
public class Situacao {

    public enum SituacaoEnum {
        AGUARDANDO_FILA,
        AGUARDANDO_DIAGNOSTICO,
        DIAGNOSTICO_FEITO,
        AGUARDANDO_PAGAMENTO,
        PROBLEMA_SOLUCIONADO,
        APARELHO_DEVOLVIDO
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private SituacaoEnum situacao;

    @Column(nullable = false)
    private Date data;

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

    public SituacaoEnum getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoEnum situacao) {
        this.situacao = situacao;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }
}