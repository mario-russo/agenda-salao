package br.com.agendasalao.agendabackend.dominio.interfaces;

import java.util.List;

import br.com.agendasalao.agendabackend.dominio.Agendamento;

public interface AgendamentoService {
    public String salvarAgendamento(Agendamento agendamento);

    public List<Agendamento> buscaTodosAgendamentos();
}
