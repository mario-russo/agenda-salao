package br.com.agendasalao.agendabackend.auth;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.agendasalao.agendabackend.auth.service.TokenService;
import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.respository.jpa.AtendenteJpaRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterValidate extends OncePerRequestFilter {

    @Autowired
    TokenService tokenService;

    @Autowired
    AtendenteJpaRepository atendenteJpaRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String token;

        var authorization = request.getHeader("Authorization");

        if (authorization != null) {
            token = authorization.replace("Bearer ", "");

            var atendenteSubject = tokenService.getSubject(token);

            var atendente = atendenteJpaRepository.findByEmail(atendenteSubject);

            var autentication = new UsernamePasswordAuthenticationToken(atendente, "", atendente.getAuthorities());

            SecurityContextHolder.getContext().setAuthentication(autentication);

        }
        filterChain.doFilter(request, response);
    }

}
