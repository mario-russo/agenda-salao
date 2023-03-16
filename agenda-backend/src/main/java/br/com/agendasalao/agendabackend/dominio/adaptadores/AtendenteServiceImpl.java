package br.com.agendasalao.agendabackend.dominio.adaptadores;

import java.util.List;
import java.util.Objects;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.agendasalao.agendabackend.dominio.interfaces.AtendenteService;
import br.com.agendasalao.agendabackend.dominio.model.Atendente;
import br.com.agendasalao.agendabackend.dominio.portas.repositories.AtendenteRepository;

@Service
public class AtendenteServiceImpl implements AtendenteService {
    private final AtendenteRepository atendenteRepository;

    public AtendenteServiceImpl(AtendenteRepository atendenteRepository) {
        this.atendenteRepository = atendenteRepository;
    }

    @Override
    public String salvaAtendente(Atendente atendente) {
        atendente.setSenha(crypt().encode(atendente.getSenha()));
        var atendenteSalvo = atendenteRepository.Salve(atendente);
        if (Objects.isNull(atendenteSalvo))
            new NullPointerException("erro ao salvar");
        return "ATENDENTE SALVO COM SUCESSO";
    }

    @Override
    public List<Atendente> buscaTodosAtendente() {
        return atendenteRepository.getAll();
    }

    private BCryptPasswordEncoder crypt() {
        return new BCryptPasswordEncoder();
    }

}
