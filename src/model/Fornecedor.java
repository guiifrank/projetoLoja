package model;

public class Fornecedor {
    private String name;
    private String descricao;
    private String telefone;
    private String email;

    public Fornecedor() {
    }

    public Fornecedor(String name, String descricao, String telefone, String email) {
        this.name = name;
        this.descricao = descricao;
        this.telefone = telefone;
        this.email = email;
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
