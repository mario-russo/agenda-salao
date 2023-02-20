package br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.ClienteEntity;
@Repository
public interface ClienteJpaRepository extends JpaRepository<ClienteEntity,Long>{
    
}
