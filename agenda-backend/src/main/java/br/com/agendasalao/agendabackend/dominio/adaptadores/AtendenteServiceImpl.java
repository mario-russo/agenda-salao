package br.com.agendasalao.agendabackend.dominio.adaptadores;

import java.util.List;

import br.com.agendasalao.agendabackend.dominio.Atendente;
import br.com.agendasalao.agendabackend.dominio.interfaces.AtendenteService;
import br.com.agendasalao.agendabackend.dominio.portas.repositories.AtendenteRepository;

public class AtendenteServiceImpl implements AtendenteService {
    private final AtendenteRepository atendenteRepository;

    public AtendenteServiceImpl(AtendenteRepository atendenteRepository) {
        this.atendenteRepository = atendenteRepository;
    }

    @Override
    public String salvaAtendente(Atendente atendente) {
        var atendenteSalvo = atendenteRepository.Salve(atendente);
        if (atendenteSalvo.getId() == null)
            return "Erro ao salvar";
        return "ATENDENTE SALVO COM SUCESSO";
    }

    @Override
    public List<Atendente> buscaTodosAtendente() {
        return atendenteRepository.getAll();
    }

}
