package br.com.agendasalao.agendabackend.application.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agendasalao.agendabackend.dominio.interfaces.ClienteSevice;
import br.com.agendasalao.agendabackend.dominio.model.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    private final ClienteSevice service;

    public ClienteController(ClienteSevice service) {
        this.service = service;
    }

    @PostMapping
    public String create(@RequestBody Cliente cliente) {
        var resul = service.salvaCliente(cliente);

        if (resul == null)
            return "ERRO AO SALVAR O CLIENTE";

        return resul;

    }

    @GetMapping
    public List<Cliente> listAll() {
        return service.buscaTodosClientes();
    }

    @GetMapping("/{id}")
    public Cliente getById(long id) {
        return null;
    }
}
