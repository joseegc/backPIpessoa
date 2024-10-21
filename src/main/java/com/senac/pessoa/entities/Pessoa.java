package com.senac.pessoa.entities;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.LogManager;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity(name="Pessoa")
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //FAZ COM QUE O ID SEJA DEFINIDO POR AUTO-INCREMENTO
    @Column(name="id")
    int id;

    @Column(name = "Nome")
    String nome;

    @Column(name = "Data de Admissao")
    Date dataAdmissao;

    @Column(name = "ativo")
    boolean ativo;

    public Pessoa() {}

    public Pessoa(String nome, Date dataAdmissao, boolean ativo) {
        this.nome = nome;
        this.dataAdmissao = dataAdmissao;
        this.ativo = ativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(Date dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "ID=" + id +
                ", nome='" + nome + '\'' +
                ", dataAdmissao=" + dataAdmissao +
                '}';
    }
}
