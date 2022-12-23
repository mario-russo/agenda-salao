package br.com.agendasalao.agendabackend.dominio;

public class Servico {
    private Long id;
    private String nome;
    private Long preco;

    public Servico(String nome, Long preco) {
        this.nome = nome;
        this.preco = preco;
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
