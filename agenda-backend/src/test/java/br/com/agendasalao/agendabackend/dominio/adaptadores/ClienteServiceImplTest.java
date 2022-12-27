package br.com.agendasalao.agendabackend.dominio.adaptadores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.agendasalao.agendabackend.dominio.Cliente;
import br.com.agendasalao.agendabackend.dominio.portas.repositories.ClienteRepository;

public class ClienteServiceImplTest {

    @Mock
    private ClienteRepository repository;

    @InjectMocks
    ClienteServiceImpl service;

    Cliente cliente;

    @Test
    void testBuscaTodosClientes() {
        
        // Montagem do Cenário
        cliente = new Cliente("mario", "mario@email", "21998463887");
        when(repository.getAll()).thenReturn(List.of(cliente));

        // chamada da função do para vericicar
        List<Cliente> reposta = service.buscaTodosClientes();

        // verifica os acertos da classe
        assertEquals(1, reposta.size());
        assertEquals(Cliente.class, reposta.get(0).getClass());
    }

    @Test
    void testSalvaCliente() {

        // Montagem do Cenário
        cliente = new Cliente("mario", "mario@email", "21998463887");
        when(repository.salvar(cliente)).thenReturn(cliente);

        // chamada da função do para vericicar
        String reposta = service.salvaCliente(cliente);

        // verifica os acertos da classe
        assertEquals(String.class, reposta.getClass());
        assertEquals("CLIENTE SALVO COM SUCESSO", reposta);

    }

    @Test
    @DisplayName("erro ao salvar o cliente!")
    void testErroAoSalvaCliente() {

        // Montagem do Cenário
        when(repository.salvar(cliente)).thenReturn(null);

        // chamada da função do para vericicar
        String reposta = service.salvaCliente(cliente);

        // verifica os acertos da classe
        assertEquals(String.class, reposta.getClass());
        assertEquals("ERRO AO SALVAR O CLIENTE", reposta);

    }

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);

        service = new ClienteServiceImpl(repository);

    }
}
