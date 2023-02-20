package br.com.agendasalao.agendabackend.application.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agendasalao.agendabackend.dominio.interfaces.ServicosService;
import br.com.agendasalao.agendabackend.dominio.model.Cliente;
import br.com.agendasalao.agendabackend.dominio.model.Servico;

@RestController
@RequestMapping("/servico")
public class ServicoController {

    private final ServicosService service;

    public ServicoController(ServicosService service) {
        this.service = service;
    }

    @GetMapping
    public List<Servico> getAll() {
        var servicos = service.BuscaTodosServicos();
        return servicos;
    }

    @PostMapping
    public String salve(@RequestBody Servico servico) {
        var result = service.salvaServico(servico);

        if (result == "ERRO AO SALVAR!!!")
            return "ERRO AO SALVAR!!!";

        return result;
    }

}
