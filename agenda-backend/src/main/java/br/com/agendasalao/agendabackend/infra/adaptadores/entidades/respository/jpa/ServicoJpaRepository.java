package br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.ServicoEntity;

public interface ServicoJpaRepository extends JpaRepository<ServicoEntity,Long> {
    
}
