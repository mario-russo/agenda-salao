package br.com.agendasalao.agendabackend.dominio.portas.repositories;

import java.util.List;

import br.com.agendasalao.agendabackend.dominio.Servico;

public interface ServicoRepository {
    public List<Servico> getAll();

    public Servico getById(Long id);

    public void salvar(Servico servico);
}
