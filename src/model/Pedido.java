package model;

import java.util.Date;

public class Pedido {
    private Integer pedido;
    private Date dataPedido;
    private Date dataEntrega;
    private String situacao;

    public Pedido() {
    }

    public Pedido(Integer pedido, Date dataPedido, Date dataEntrega, String situacao) {
        this.pedido = pedido;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.situacao = situacao;
    }

    public Integer getPedido() {
        return pedido;
    }

    public void setPedido(Integer pedido) {
        this.pedido = pedido;
    }

    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "pedido=" + pedido +
                ", dataPedido=" + dataPedido +
                ", dataEntrega=" + dataEntrega +
                ", situacao='" + situacao + '\'' +
                '}';
    }
}
