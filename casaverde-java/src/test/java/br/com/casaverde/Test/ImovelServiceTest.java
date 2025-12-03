package br.com.casaverde.Test;

import br.com.casaverde.model.Imovel;
import br.com.casaverde.service.ImovelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImovelServiceTest {

    private ImovelService service;

    @BeforeEach
    void setUp() {
        service = new ImovelService();
    }

    @Test
    void test01_criarImovel_valido() {
        Imovel i = service.criarImovel("Casa ampla", "Rua A, 123", 350000.0, 3);
        assertNotNull(i);
        assertEquals("Casa ampla", i.getTitulo());
    }

    @Test
    void test02_criarImovel_tituloVazio() {
        Imovel i = service.criarImovel(" ", "Rua B, 45", 200000.0, 2);
        assertNull(i);
    }

    @Test
    void test03_criarImovel_precoNegativo() {
        Imovel i = service.criarImovel("Apartamento", "Av. Central, 500", -1.0, 2);
        assertNull(i);
    }

    @Test
    void test04_criarImovel_quartosNegativos() {
        Imovel i = service.criarImovel("Studio", "Rua C, 10", 120000.0, -1);
        assertNull(i);
    }

    @Test
    void test05_desativarImovel() {
        Imovel i = new Imovel("Cobertura", "Rua D, 77", 900000.0, 4);
        service.desativar(i);
        assertFalse(i.isAtivo());
    }

    @Test
    void test06_ativarImovel() {
        Imovel i = new Imovel("Cobertura", "Rua D, 77", 900000.0, 4);
        service.desativar(i);
        service.ativar(i);
        assertTrue(i.isAtivo());
    }

    @Test
    void test07_atualizarPreco_valido() {
        Imovel i = new Imovel("Casa", "Rua E, 5", 300000.0, 3);
        boolean ok = service.atualizarPreco(i, 310000.0);
        assertTrue(ok);
        assertEquals(310000.0, i.getPreco());
    }

    @Test
    void test08_atualizarPreco_negativo() {
        Imovel i = new Imovel("Casa", "Rua E, 5", 300000.0, 3);
        boolean ok = service.atualizarPreco(i, -10.0);
        assertFalse(ok);
        assertEquals(300000.0, i.getPreco());
    }
}

