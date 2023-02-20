package br.com.agendasalao.agendabackend.dominio.adaptadores;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.agendasalao.agendabackend.dominio.interfaces.AgendamentoService;
import br.com.agendasalao.agendabackend.dominio.model.Agendamento;
import br.com.agendasalao.agendabackend.dominio.portas.repositories.AgendamentoRepository;
@Service
public class AgendamentoServiceImpl implements AgendamentoService {
    private final AgendamentoRepository agendamentoRepository;

    public AgendamentoServiceImpl(AgendamentoRepository agendamentoRepository) {
        this.agendamentoRepository = agendamentoRepository;
    }

    @Override
    public String salvarAgendamento(Agendamento agendamento) {
        Agendamento AgenmentoSalvo = agendamentoRepository.salvar(agendamento);

        if (AgenmentoSalvo.getId() == null)
            return "Erro ao Salvar";

        return "Salvo com Sucesso ";
    }

    @Override
    public List<Agendamento> buscaTodosAgendamentos() {
        
        return agendamentoRepository.getAll();
    }

}
