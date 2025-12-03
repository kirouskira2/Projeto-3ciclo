package br.com.casaverde.service;

import br.com.casaverde.model.Cliente;

/**
 * Operações básicas de cliente.
 */
public class ClienteService {

    public Cliente criarCliente(String nome, String email, String senha) {
        if (nome == null || nome.trim().isEmpty()) return null;
        if (email == null || email.trim().isEmpty()) return null;
        if (!email.contains("@")) return null;
        if (senha == null || senha.length() < 6) return null;
        return new Cliente(nome, email, senha);
    }

    public Cliente desativarCliente(Cliente cliente) {
        cliente.setAtivo(false);
        return cliente;
    }

    public boolean autenticar(Cliente cliente, String senhaFornecida) {
        return cliente.getSenha().equals(senhaFornecida);
    }
}

