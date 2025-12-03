package br.com.casaverde.Test;

import br.com.casaverde.model.Visita;
import br.com.casaverde.service.VisitaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class VisitaServiceTest {

    private VisitaService service;

    @BeforeEach
    void setUp() {
        service = new VisitaService();
    }

    @Test
    void test01_criarVisita_valida() {
        LocalDateTime futura = LocalDateTime.now().plusDays(1);
        Visita v = service.criarVisita(1L, 10L, futura);
        assertNotNull(v);
        assertEquals("CRIADA", v.getStatus());
    }

    @Test
    void test02_criarVisita_dataPassada() {
        LocalDateTime passada = LocalDateTime.now().minusDays(1);
        Visita v = service.criarVisita(1L, 10L, passada);
        assertNull(v);
    }

    @Test
    void test03_criarVisita_semCliente() {
        LocalDateTime futura = LocalDateTime.now().plusDays(1);
        Visita v = service.criarVisita(null, 10L, futura);
        assertNull(v);
    }

    @Test
    void test04_criarVisita_semImovel() {
        LocalDateTime futura = LocalDateTime.now().plusDays(1);
        Visita v = service.criarVisita(1L, null, futura);
        assertNull(v);
    }

    @Test
    void test05_cancelarVisita() {
        Visita v = new Visita(1L, 10L, LocalDateTime.now().plusDays(2));
        boolean ok = service.cancelar(v);
        assertTrue(ok);
        assertEquals("CANCELADA", v.getStatus());
    }

    @Test
    void test06_confirmarVisita() {
        Visita v = new Visita(1L, 10L, LocalDateTime.now().plusDays(2));
        boolean ok = service.confirmar(v);
        assertTrue(ok);
        assertEquals("CONFIRMADA", v.getStatus());
    }

    @Test
    void test07_reagendar_valido() {
        Visita v = new Visita(1L, 10L, LocalDateTime.now().plusDays(2));
        boolean ok = service.reagendar(v, LocalDateTime.now().plusDays(3));
        assertTrue(ok);
        assertEquals("CRIADA", v.getStatus());
    }

    @Test
    void test08_reagendar_dataPassada() {
        Visita v = new Visita(1L, 10L, LocalDateTime.now().plusDays(2));
        boolean ok = service.reagendar(v, LocalDateTime.now().minusDays(1));
        assertFalse(ok);
        assertEquals(LocalDateTime.now().plusDays(2).getDayOfMonth(), v.getDataHora().getDayOfMonth());
    }
}

