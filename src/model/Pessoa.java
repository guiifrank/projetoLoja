package model;

public class Pessoa {
    private String name;
    private String telefone;
    private String email;

    public Pessoa() {
    }

    public Pessoa(String name, String telefone, String email) {
        this.name = name;
        this.telefone = telefone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
