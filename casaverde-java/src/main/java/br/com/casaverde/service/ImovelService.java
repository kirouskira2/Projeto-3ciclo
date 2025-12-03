package br.com.casaverde.service;

import br.com.casaverde.model.Imovel;

/**
 * Operações simples sobre imóvel.
 */
public class ImovelService {

    public Imovel criarImovel(String titulo, String endereco, double preco, int quartos) {
        if (titulo == null || titulo.trim().isEmpty()) return null;
        if (endereco == null || endereco.trim().isEmpty()) return null;
        if (preco < 0) return null;
        if (quartos < 0) return null;
        return new Imovel(titulo, endereco, preco, quartos);
    }

    public Imovel ativar(Imovel imovel) {
        imovel.setAtivo(true);
        return imovel;
    }

    public Imovel desativar(Imovel imovel) {
        imovel.setAtivo(false);
        return imovel;
    }

    public boolean atualizarPreco(Imovel imovel, double novoPreco) {
        if (novoPreco < 0) return false;
        imovel.setPreco(novoPreco);
        return true;
    }
}

