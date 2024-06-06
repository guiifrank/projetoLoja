package model;

public class ItemPedido {
    private Integer quantidade;
    private Double valor;

    public ItemPedido() {
    }

    public ItemPedido(Integer quantidade, Double valor) {
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
