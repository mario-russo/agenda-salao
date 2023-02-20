package br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.agendasalao.agendabackend.dominio.model.Servico;
import br.com.agendasalao.agendabackend.dominio.portas.repositories.ServicoRepository;
import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.ServicoEntity;
import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository.jpa.ServicoJpaRepository;

@Component
public class ServicoRepositoryImpl implements ServicoRepository{
    private final  ServicoJpaRepository repository;

    public ServicoRepositoryImpl(ServicoJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Servico> getAll() {
        var entity = repository.findAll();
        var servicos = entity.stream().map(item -> new Servico(item)).collect(Collectors.toList());
        return servicos;
    }

    @Override
    public Servico getById(Long id) {
        var entity = repository.findById(id);
        return new Servico(entity.get());
    }

    @Override
    public Servico salvar(Servico servico) {
        var entity = new ServicoEntity(servico);
        var servicoSalvo = repository.save(entity);
        return new Servico(servicoSalvo);
    }
    
}
