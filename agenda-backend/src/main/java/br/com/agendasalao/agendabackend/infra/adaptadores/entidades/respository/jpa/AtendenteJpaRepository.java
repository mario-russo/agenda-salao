package br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.AtendenteEntity;

public interface AtendenteJpaRepository extends JpaRepository<AtendenteEntity,Long>{
   public AtendenteEntity findByEmail(String username);
}
