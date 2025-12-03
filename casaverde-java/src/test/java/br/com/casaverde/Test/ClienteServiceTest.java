package br.com.casaverde.Test;

import br.com.casaverde.model.Cliente;
import br.com.casaverde.service.ClienteService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteServiceTest {

    private ClienteService service;

    @BeforeEach
    void setUp() {
        service = new ClienteService();
    }

    @Test
    void test01_criarCliente_valido() {
        Cliente c = service.criarCliente("Ana", "ana@email.com", "senha123");
        assertNotNull(c);
        assertEquals("Ana", c.getNome());
    }

    @Test
    void test02_criarCliente_emailInvalido() {
        Cliente c = service.criarCliente("Ana", "ana.email.com", "senha123");
        assertNull(c);
    }

    @Test
    void test03_criarCliente_senhaCurta() {
        Cliente c = service.criarCliente("Ana", "ana@email.com", "123");
        assertNull(c);
    }

    @Test
    void test04_criarCliente_nomeVazio() {
        Cliente c = service.criarCliente(" ", "ana@email.com", "senha123");
        assertNull(c);
    }

    @Test
    void test05_desativarCliente() {
        Cliente c = new Cliente("Bia", "bia@email.com", "senha123");
        service.desativarCliente(c);
        assertFalse(c.isAtivo());
    }

    @Test
    void test06_autenticar_senhaCorreta() {
        Cliente c = new Cliente("Carlos", "carlos@email.com", "senhaForte");
        assertTrue(service.autenticar(c, "senhaForte"));
    }

    @Test
    void test07_autenticar_senhaErrada() {
        Cliente c = new Cliente("Carlos", "carlos@email.com", "senhaForte");
        assertFalse(service.autenticar(c, "senhaErrada"));
    }

    @Test
    void test08_novoCliente_comecaAtivo() {
        Cliente c = service.criarCliente("Duda", "duda@email.com", "outrasenha");
        assertNotNull(c);
        assertTrue(c.isAtivo());
    }
}

