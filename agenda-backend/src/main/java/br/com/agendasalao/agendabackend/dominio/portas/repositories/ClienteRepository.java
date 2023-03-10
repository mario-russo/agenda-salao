package br.com.agendasalao.agendabackend.dominio.portas.repositories;

import java.util.List;

import br.com.agendasalao.agendabackend.dominio.model.Cliente;

public interface ClienteRepository {
    public List<Cliente> getAll();
    public Cliente getById(Long id);
    public Cliente salvar(Cliente cliente);
}
