package model;

public class Produto {
    private String name;
    private String descricao;
    private byte[] foto;
    private int id;
    private Fornecedor fornecedor;
    private int quantEstoque;

    public Produto(){
    }

    public Produto(int id, String name, Fornecedor fornecedor ,String descricao, byte[] foto) {
        this.id = id;
        this.name = name;
        this.fornecedor = fornecedor;
        this.descricao = descricao;
        this.foto = foto;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public int getQuantEstoque() {
        return quantEstoque;
    }

    public void setQuantEstoque(int quantEstoque) {
        this.quantEstoque = quantEstoque;
    }

    @Override
    public String toString() {
        return "Produto [id=" + id + ", nome=" + name + ", fornecedor=" + fornecedor + ", quantidadeEmEstoque=" + quantEstoque + "]";
    }

}
