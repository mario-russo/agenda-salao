package br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.ClienteEntity;

public interface ClienteJpaRepository extends JpaRepository<ClienteEntity,Long>{
    
}
