package br.com.agendasalao.agendabackend.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agendasalao.agendabackend.auth.service.TokenService;
import br.com.agendasalao.agendabackend.infra.adaptadores.entidades.AtendenteEntity;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @GetMapping("/login")
    public String login(@RequestBody LoginDto loginDto) {
       UsernamePasswordAuthenticationToken authenticationToken =  new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getSenha());

       var  authentication = this.authenticationManager.authenticate(authenticationToken);

       var usuario = (AtendenteEntity) authentication.getPrincipal();
        

       return tokenService.gerarToken(usuario);
        
    }
}
