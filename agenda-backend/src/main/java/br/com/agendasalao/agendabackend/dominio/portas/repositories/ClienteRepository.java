package br.com.agendasalao.agendabackend.dominio.portas.repositories;

import java.util.List;

import br.com.agendasalao.agendabackend.dominio.Cliente;

public interface ClienteRepository {
    public List<Cliente> getAll();
    public Cliente getById(Long id);
    public void salvar(Cliente cliente);
}
