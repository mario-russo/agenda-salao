package br.com.agendasalao.agendabackend.dominio.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.agendasalao.agendabackend.dominio.interfaces.ClienteSevice;
import br.com.agendasalao.agendabackend.dominio.model.Cliente;
import br.com.agendasalao.agendabackend.dominio.portas.repositories.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteSevice {
    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public String salvaCliente(Cliente cliente) {

        Cliente clienteSalvo = clienteRepository.salvar(cliente);

        if (clienteSalvo.getId() == null)
            return "ERRO AO SALVAR O CLIENTE";

        return "CLIENTE SALVO COM SUCESSO";
    }

    @Override
    public List<Cliente> buscaTodosClientes() {
        var entity =  clienteRepository.getAll();
        return  entity;
    }

}
