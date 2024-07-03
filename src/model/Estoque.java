package model;

import java.io.Serializable;

public class Estoque implements Serializable {
    private int id;
    private Produto produto;
    private int quantidade;
    private double preco;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "id=" + id +
                ", produto=" + produto +
                ", quantidade=" + quantidade +
                ", preco=" + preco +
                '}';
    }
}
