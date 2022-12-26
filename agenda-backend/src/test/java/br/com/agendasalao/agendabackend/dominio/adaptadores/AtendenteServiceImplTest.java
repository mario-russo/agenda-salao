package br.com.agendasalao.agendabackend.dominio.adaptadores;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.agendasalao.agendabackend.dominio.Atendente;
import br.com.agendasalao.agendabackend.dominio.portas.repositories.AtendenteRepository;

@ExtendWith(MockitoExtension.class)
public class AtendenteServiceImplTest {
    @Mock
    private AtendenteRepository atendenteRepository;

    @InjectMocks
    private AtendenteServiceImpl service;

    private Atendente atendente;

    @Test
    void testBuscaTodosAtendente() {
        atendente = new Atendente("mario", "mario@mario", "1234");

        when(atendenteRepository.getAll()).thenReturn(List.of(atendente));

        List<Atendente> resposta = service.buscaTodosAtendente();

        verify(atendenteRepository).getAll();
        assertNotNull(resposta);
        assertEquals(1, resposta.size());
        assertEquals(Atendente.class, resposta.get(0).getClass());
 
    }

    @Test
    void testSalvaAtendente() {
        atendente = new Atendente("mario", "mario@mario", "1234");
        when(atendenteRepository.Salve(any())).thenReturn(atendente);

        String resposta = service.salvaAtendente(atendente);

        verify(atendenteRepository).Salve(atendente);

        assertEquals("ATENDENTE SALVO COM SUCESSO", resposta);
        assertEquals(String.class, resposta.getClass());

    }

    @Test
    @DisplayName("verifica se o o Id do cliente é gerado!")
    void testSalvaAtendenteErro() {

        when(atendenteRepository.Salve(any())).thenReturn(null);

        String resposta = service.salvaAtendente(atendente);

        verify(atendenteRepository).Salve(atendente);

        assertEquals("ERRO AO SALVAR", resposta);
        assertEquals(String.class, resposta.getClass());

    }

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        service = new AtendenteServiceImpl(atendenteRepository);

    }
}
