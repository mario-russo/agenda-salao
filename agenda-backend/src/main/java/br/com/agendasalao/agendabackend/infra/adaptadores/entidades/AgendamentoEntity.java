package br.com.agendasalao.agendabackend.infra.adaptadores.entidades;

import javax.persistence.*;

import br.com.agendasalao.agendabackend.dominio.Agendamento;
import br.com.agendasalao.agendabackend.dominio.Atendente;
import br.com.agendasalao.agendabackend.dominio.Cliente;
import br.com.agendasalao.agendabackend.dominio.Servico;

@Entity
public class AgendamentoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Cliente cliente;
    private Servico servico;
    private String data;
    private String hora;
    private Atendente atendente;
    private String endereco;

    public AgendamentoEntity(Agendamento agendamento){
        this.cliente= agendamento.getCliente();
        this.servico = agendamento.getServico();
        this.data= agendamento.getData();
        this.hora = agendamento.getHora();
        this.atendente = agendamento.getAtendente();
        this.endereco = agendamento.getEndereco();
    }

    public Long getId() {
        return id;
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

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
}
