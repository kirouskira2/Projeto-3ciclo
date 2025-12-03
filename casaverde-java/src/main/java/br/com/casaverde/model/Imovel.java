package br.com.casaverde.model;

/**
 * Dados do imóvel anunciado.
 */
public class Imovel {

    private String titulo;
    private String endereco;
    private double preco;
    private int quartos;
    private boolean ativo;

    public Imovel(String titulo, String endereco, double preco, int quartos) {
        this.titulo = titulo;
        this.endereco = endereco;
        this.preco = preco;
        this.quartos = quartos;
        this.ativo = true; // começa ativo
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}

