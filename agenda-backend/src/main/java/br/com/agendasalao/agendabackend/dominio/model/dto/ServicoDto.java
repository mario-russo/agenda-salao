package br.com.agendasalao.agendabackend.dominio.model.dto;

public class ServicoDto {
    private String nome;
    private Long preco;

    public ServicoDto(String nome, Long preco) {
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

}
