package br.com.agendasalao.agendabackend.infra.adaptadores.entidades;

import jakarta.persistence.*;

import br.com.agendasalao.agendabackend.dominio.model.Atendente;

@Entity
@Table(name = "atendente")
public class AtendenteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    public AtendenteEntity(Atendente atendente) {
        this.nome = atendente.getNome();
        this.email = atendente.getEmail();
        this.senha = atendente.getSenha();
    }
    

    public AtendenteEntity() {
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
