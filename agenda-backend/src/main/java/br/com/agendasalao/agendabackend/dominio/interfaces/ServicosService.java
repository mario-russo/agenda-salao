package br.com.agendasalao.agendabackend.dominio.interfaces;

import java.util.List;

import br.com.agendasalao.agendabackend.dominio.model.Servico;

public interface ServicosService {
    public List<Servico> BuscaTodosServicos();

    public String salvaServico(Servico servico);
}
