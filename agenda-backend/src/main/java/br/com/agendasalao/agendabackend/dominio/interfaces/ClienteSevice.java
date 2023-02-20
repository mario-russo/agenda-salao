package br.com.agendasalao.agendabackend.dominio.interfaces;

import java.util.List;

import br.com.agendasalao.agendabackend.dominio.model.Cliente;

public interface ClienteSevice {
    public String salvaCliente(Cliente cliente);

    public List<Cliente> buscaTodosClientes();
}
