package br.com.agendasalao.agendabackend.application.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agendasalao.agendabackend.dominio.interfaces.AgendamentoService;
import br.com.agendasalao.agendabackend.dominio.model.Agendamento;

@RestController
@RequestMapping("/agendamento")
public class AgendamentoController {

    private final AgendamentoService service;

    public AgendamentoController(AgendamentoService service) {
        this.service = service;
    }
    
    @GetMapping
    public List<Agendamento> getAll(){
        return service.buscaTodosAgendamentos();
    }
    @PostMapping
    public String create (@RequestBody Agendamento agendamento){
        var result  = service.salvarAgendamento(agendamento);
        return result;
    }
    
}
