package br.com.agendasalao.agendabackend.dominio.interfaces;

import java.util.List;

import br.com.agendasalao.agendabackend.dominio.Atendente;

public interface AtendenteService {
    public String salvaAtendente(Atendente atendente);

    public List<Atendente> buscaTodosAtendente();
}
