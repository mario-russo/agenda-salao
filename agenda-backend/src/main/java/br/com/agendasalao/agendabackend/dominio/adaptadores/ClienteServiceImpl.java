package br.com.agendasalao.agendabackend.dominio.adaptadores;

import java.util.List;

import br.com.agendasalao.agendabackend.dominio.Cliente;
import br.com.agendasalao.agendabackend.dominio.interfaces.ClienteSevice;
import br.com.agendasalao.agendabackend.dominio.portas.repositories.ClienteRepository;

public class ClienteServiceImpl implements ClienteSevice {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public String salvaCliente(Cliente cliente) {

        Cliente clienteSalvo = clienteRepository.salvar(cliente);

        if (clienteSalvo.getId() == null)
            return "erro ao salvar o cliente";

        return "CLIENTE SALVO COM SUCESSO";
    }

    @Override
    public List<Cliente> buscaTodosClientes() {

        return clienteRepository.getAll();
    }

}
