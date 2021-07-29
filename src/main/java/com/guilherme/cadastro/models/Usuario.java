package com.guilherme.cadastro.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {

    @Id
    private String cpfOuCnpj;

    private String nome;


    public Usuario() {

    }

    public Usuario(String nome, String cpfOuCnpj) {
        this.nome = nome;
        this.cpfOuCnpj = cpfOuCnpj;
    }

    public String getNome() {
        return this.nome;
    }

    public String getCpfOuCnpj() {
        return this.cpfOuCnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpfOuCnpj(String cpfOuCnpj) {
        this.cpfOuCnpj = cpfOuCnpj;
    }
}
