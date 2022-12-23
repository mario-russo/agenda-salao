package br.com.agendasalao.agendabackend.dominio.adaptadores;

import java.util.List;

import br.com.agendasalao.agendabackend.dominio.Servico;
import br.com.agendasalao.agendabackend.dominio.interfaces.ServicosService;
import br.com.agendasalao.agendabackend.dominio.portas.repositories.ServicoRepository;

public class ServicosServiceImpl implements ServicosService {
    private final ServicoRepository repository;

    public ServicosServiceImpl(ServicoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Servico> BuscaTodosServicos() {
        return repository.getAll();
    }

    @Override
    public String salvaServico(Servico servico) {
        var servicoSalvo = repository.salvar(servico);
        if(servicoSalvo.getId() == null)
            return"ERRO AO SALVAR!!!";
        return "SERVIÇO SALVO COM SUCESSO!!!";
    }

}
