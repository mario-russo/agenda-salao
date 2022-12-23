package br.com.agendasalao.agendabackend.dominio.portas.repositories;

import java.util.List;

import br.com.agendasalao.agendabackend.dominio.Agendamento;

public interface AgendamentoRepository {
    public List<Agendamento> getAll();

    public Agendamento getById(Long id);
 /**
  *   Retorna o agendamento salvo 
  * @param agendamento
  * @return Agendaento
  */
    public Agendamento salvar(Agendamento agendamento);
}
