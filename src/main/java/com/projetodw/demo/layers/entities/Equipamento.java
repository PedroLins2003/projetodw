package com.projetodw.demo.layers.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;


@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"requisicao_id", "servico"}))
public class Equipamento {

    public enum TipoEnum {
        NOTBOOK,
        PC_DE_MESA
    }

    public enum MarcaEnum {
        SAMSUNG
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private TipoEnum tipo;

    @Column
    private MarcaEnum marca;

    @ManyToOne
    @JoinColumn(name = "requisicao_id", nullable = false)
    private Requisicao requisicao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoEnum tipo) {
        this.tipo = tipo;
    }

    public MarcaEnum getModelo() {
        return marca;
    }

    public void setModelo(MarcaEnum marca) {
        this.marca = marca;
    }
    
    public Requisicao getRequisicao() {
        return requisicao;
    }

    public void setRequisicao(Requisicao requisicao) {
        this.requisicao = requisicao;
    }
}