package model;

public class Produto {
    private String name;
    private String descricao;
    private int id;
    private Fornecedor fornecedor;
    private int quantEstoque;

    public Produto(int id, String name, Fornecedor fornecedor ,String descricao) {
        this.id = id;
        this.name = name;
        this.fornecedor = fornecedor;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    @Override
    public String toString() {
        return "Produto : ID = " + id + ", Nome = " + name + ", [" + fornecedor + "], Quantidade em estoque = " + quantEstoque;
    }
}
