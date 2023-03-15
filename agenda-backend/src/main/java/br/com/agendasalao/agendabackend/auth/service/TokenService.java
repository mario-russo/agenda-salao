package br.com.agendasalao.agendabackend.auth.service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.AtendenteEntity;

@Service
public class TokenService {

    public String gerarToken(AtendenteEntity usuario) {
        return JWT.create()
            .withIssuer("Ptendente")
            .withSubject(usuario.getEmail())
            .withClaim("id", usuario.getId())
            .withExpiresAt( LocalDateTime.now()
                            .plusMinutes(60)
                            .toInstant(ZoneOffset.of("-03:00"))
            ).sign(Algorithm.HMAC256("atentende"));
    }

}
