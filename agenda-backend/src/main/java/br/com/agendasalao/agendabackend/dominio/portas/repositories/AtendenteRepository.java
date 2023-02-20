package br.com.agendasalao.agendabackend.dominio.portas.repositories;

import java.util.List;

import br.com.agendasalao.agendabackend.dominio.model.Atendente;

public interface AtendenteRepository {
    public List<Atendente> getAll();
    public Atendente getById(Long id);
    public Atendente Salve(Atendente atendente);
}
