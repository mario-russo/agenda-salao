package br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import br.com.agendasalao.agendabackend.dominio.model.Agendamento;
import br.com.agendasalao.agendabackend.dominio.portas.repositories.AgendamentoRepository;
import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.AgendamentoEntity;
import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository.jpa.AgendamentoJpaRepository;

@Repository
public class AgendamentoRepositoryImpl implements AgendamentoRepository{

    private final  AgendamentoJpaRepository repository;
    

    public AgendamentoRepositoryImpl(AgendamentoJpaRepository repository) {
        this.repository = repository;
    }


    @Override
    public List<Agendamento> getAll() {
        var agendamentoEntity  =  repository.findAll();
        List<Agendamento> agendamento = agendamentoEntity.stream().map(x -> new Agendamento(x)).collect(Collectors.toList());
        return agendamento;
    }


    @Override
    public Agendamento getById(Long id) {
       var entity =  repository.findById(id);
        return new Agendamento(entity.get());
    }


    @Override
    public Agendamento salvar(Agendamento agendamento) {
        var entity = new AgendamentoEntity(agendamento);
        var salveEntity = repository.save(entity);
        return new Agendamento(salveEntity);
    }


}
