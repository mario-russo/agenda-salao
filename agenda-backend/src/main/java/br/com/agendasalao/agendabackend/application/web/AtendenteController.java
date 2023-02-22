package br.com.agendasalao.agendabackend.application.web;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agendasalao.agendabackend.dominio.interfaces.AtendenteService;
import br.com.agendasalao.agendabackend.dominio.model.Atendente;

@RestController
@RequestMapping("/atendente")
public class AtendenteController {
    private final AtendenteService service;

    public AtendenteController(AtendenteService service) {
        this.service = service;
    }
    
    @GetMapping
    public 
    List<Atendente> listAll(){
       return service.buscaTodosAtendente();
    }

    @PostMapping
    public String create(@RequestBody Atendente agendamento){
        var result = service.salvaAtendente(agendamento);
        return result;
    }
    
}
