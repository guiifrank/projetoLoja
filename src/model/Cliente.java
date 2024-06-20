package model;

public class Cliente extends Pessoa {
    private String name;
    private String email;
    private String telefone;
    private String cartaoCredito;
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String name, String email, String telefone, String cartaoCredito) {
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.cartaoCredito = cartaoCredito;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCartaoCredito() {
        return cartaoCredito;
    }

    public void setCartaoCredito(String cartaoCredito) {
        this.cartaoCredito = cartaoCredito;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", cartaoCredito='" + cartaoCredito + '\'' +
                '}';
    }
}
