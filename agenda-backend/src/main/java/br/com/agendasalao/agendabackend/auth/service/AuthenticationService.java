package br.com.agendasalao.agendabackend.auth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository.jpa.AtendenteJpaRepository;

@Service
public class AuthenticationService implements UserDetailsService {

    private final AtendenteJpaRepository repository;

    public AuthenticationService(AtendenteJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByEmail(username);
    }

}
