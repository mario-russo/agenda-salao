package br.com.agendasalao.agendabackend.dominio.model;

import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.AgendamentoEntity;

public class Agendamento {
    private Long id;
    private Cliente cliente;
    private Servico servico;
    private String data;
    private String hora;
    private Atendente atendente;
    private String endereco;

    public Agendamento(Cliente cliente, Servico servico, String data, String hora, Atendente atendente,
            String endereco) {
        this.cliente = cliente;
        this.servico = servico;
        this.data = data;
        this.hora = hora;
        this.atendente = atendente;
        this.endereco = endereco;
    }
    

    public Agendamento(AgendamentoEntity agendamentoEntity) {
        this.id = agendamentoEntity.getId();
        this.data = agendamentoEntity.getData();
        this.hora = agendamentoEntity.getHora();
        this.endereco = agendamentoEntity.getEndereco();
    }
     

    public Agendamento() {
    }


    public Long getId() {
        return id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
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
}
