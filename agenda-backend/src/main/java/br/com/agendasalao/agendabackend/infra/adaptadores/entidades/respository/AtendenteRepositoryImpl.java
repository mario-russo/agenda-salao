package br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.agendasalao.agendabackend.dominio.model.Atendente;
import br.com.agendasalao.agendabackend.dominio.portas.repositories.AtendenteRepository;
import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.AtendenteEntity;
import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository.jpa.AtendenteJpaRepository;

@Repository
public class AtendenteRepositoryImpl implements AtendenteRepository {

    private final AtendenteJpaRepository repository;
    
    public AtendenteRepositoryImpl(AtendenteJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Atendente> getAll() {
        var entity = repository.findAll();
        List<Atendente> atendente = entity.stream().map(item -> new Atendente(item)).collect(Collectors.toList());
        return atendente;
    }

    @Override
    public Atendente getById(Long id) {
        var entity = repository.findById(id);
        return new Atendente(entity.get());
    }

    @Override
    public Atendente Salve(Atendente atendente) {
        var entity = new AtendenteEntity(atendente);
        return new Atendente(entity);
    }
    
}
