package br.com.agendasalao.agendabackend.infra.adaptadores.entidades;

import java.util.List;

import jakarta.persistence.*;

import br.com.agendasalao.agendabackend.dominio.model.Agendamento;

@Entity
@Table(name = "agendamento")
public class AgendamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String data;
    private String hora;
    private String endereco;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "agendamento_servicos", joinColumns = { @JoinColumn(name = "servico_id") }, inverseJoinColumns = {
            @JoinColumn(name = "agendamento") })
    private List<ServicoEntity> servico;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    private ClienteEntity cliente;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "atendente_id")
    private AtendenteEntity atendente;

    public AgendamentoEntity(Agendamento agendamento) {
        this.data = agendamento.getData();
        this.hora = agendamento.getHora();
        this.endereco = agendamento.getEndereco();
    }

    public Long getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

}
