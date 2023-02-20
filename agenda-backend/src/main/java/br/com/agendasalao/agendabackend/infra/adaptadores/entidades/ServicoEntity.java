package br.com.agendasalao.agendabackend.infra.adaptadores.entidades;

import java.util.List;

import javax.persistence.*;

import br.com.agendasalao.agendabackend.dominio.model.Servico;

@Entity
@Table(name = "servicos")
public class ServicoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private Long preco;
    @ManyToMany(mappedBy="servico", cascade = CascadeType.ALL)
    private List<AgendamentoEntity >agendamento;

    public ServicoEntity(Servico servico) {
        this.nome = servico.getNome();
        this.preco = servico.getPreco();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
