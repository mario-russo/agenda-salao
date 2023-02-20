package br.com.agendasalao.agendabackend;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agendasalao.agendabackend.dominio.model.Agendamento;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/agenda")
public class testeController {
    @GetMapping()
    public String agendamentos() {
        return "todos agendamentos";
    }

    @PostMapping()
    public Agendamento salvar(@RequestBody Agendamento agenda) {

        return agenda;
    }

}
