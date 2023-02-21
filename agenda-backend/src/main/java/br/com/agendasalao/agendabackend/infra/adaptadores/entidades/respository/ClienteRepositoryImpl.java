package br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.agendasalao.agendabackend.dominio.model.Cliente;
import br.com.agendasalao.agendabackend.dominio.portas.repositories.ClienteRepository;
import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.ClienteEntity;
import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository.jpa.ClienteJpaRepository;

@Component
public class ClienteRepositoryImpl implements ClienteRepository{
    private final ClienteJpaRepository repository;
    
    public ClienteRepositoryImpl(ClienteJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cliente> getAll() {
       var entity = repository.findAll();
       List<Cliente> cliente = entity.stream().map(item -> new Cliente(item)).collect(Collectors.toList());
        return cliente;
    }

    @Override
    public Cliente getById(Long id) {
        var entity= repository.findById(id);
        return new Cliente(entity.get());
    }

    @Override
    public Cliente salvar(Cliente cliente) {
        var entity = new ClienteEntity(cliente);
        var entitySalva = repository.save(entity);
        return new Cliente(entitySalva);
    }
    
}
