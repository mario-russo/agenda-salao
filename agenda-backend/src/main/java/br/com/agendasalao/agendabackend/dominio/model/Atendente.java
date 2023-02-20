package br.com.agendasalao.agendabackend.dominio.model;

import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.AtendenteEntity;

public class Atendente {
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public Atendente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    

    public Atendente(AtendenteEntity atendenteEntity) {
        this.nome = atendenteEntity.getNome();
        this.email = atendenteEntity.getEmail();
        this.senha = atendenteEntity.getSenha();
    }



    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
