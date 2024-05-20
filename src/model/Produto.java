package model;

public class Produto {
    private String name;
    private String descricao;
    private byte[] foto;

    public Produto(){
    }

    public Produto(String name, String descricao, byte[] foto) {
        this.name = name;
        this.descricao = descricao;
        this.foto = foto;
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

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }


}
