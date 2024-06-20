package model;

import java.util.List;

public class Fornecedor extends Pessoa {
    private String name;
    private String descricao;
    private String telefone;
    private String email;
    private int id;
    private Endereco endereco;
    private List<Produto> produtos;

    public Fornecedor() {
    }

    public Fornecedor(int id, String name, String descricao, String telefone, String email, Endereco endereco) {
        this.id = id;
        this.name = name;
        this.descricao = descricao;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Fornecedor: ID = " + id +
                ", Nome = " + name +
                ", Descrição = " + descricao +
                ", Telefone = " + telefone +
                ", Email = " + email +
                 ", " + endereco;
    }
}
