package br.com.agendasalao.agendabackend.dominio.model;

import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.ServicoEntity;

public class Servico {
    private Long id;
    private String nome;
    private Long preco;

    public Servico(String nome, Long preco) {
        this.nome = nome;
        this.preco = preco;
    }

    

    public Servico(ServicoEntity entity) {
        this.nome = entity.getNome();
        this.preco = entity.getPreco();
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getPreco() {
        return preco;
    }

    public void setPreco(Long preco) {
        this.preco = preco;
    }

    public Long getId() {
        return id;
    }
}
