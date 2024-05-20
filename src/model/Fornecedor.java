package model;

import java.util.ArrayList;
import java.util.List;

public class Fornecedor {
    private String name;
    private String descricao;
    private String telefone;
    private String email;
    private int id;  //USUARIO PODE SETAR ID? OU SISTEMA SETA ID AO INLCUIR FORNECEDOR?

    private List<Fornecedor> fornecedores = new ArrayList<>();

    public Fornecedor() {
    }

    public Fornecedor(String name, String descricao, String telefone, String email, int id) {
        this.name = name;
        this.descricao = descricao;
        this.telefone = telefone;
        this.email = email;
        this.id = id;
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

    //METODOS PARA INLCUIR, ALTERAR, EXCLUIR E CONSULTAR (POR CODIGO E NOME)

}
