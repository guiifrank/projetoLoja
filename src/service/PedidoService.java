package service;

import model.Pedido;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PedidoService {
    private List<Pedido> pedidos;

    public PedidoService() {
        pedidos = new ArrayList<>();
    }

    public void adicionarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public void atualizarPedido(Pedido pedido) {
        Pedido pedidoExistente = consultarPedidoPorId(pedido.getId());
        if (pedidoExistente != null) {
            pedidoExistente.setDataPedido(pedido.getDataPedido());
            pedidoExistente.setDataEntrega(pedido.getDataEntrega());
            pedidoExistente.setSituacao(pedido.getSituacao());
            pedidoExistente.setCliente(pedido.getCliente());
            pedidoExistente.setItens(pedido.getItens());
        }
    }

    public void removerPedido(int id) {
        Pedido pedido = consultarPedidoPorId(id);
        if (pedido != null) {
            pedidos.remove(pedido);
        }
    }

    public Pedido consultarPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    public void salvarPedidos() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("pedidos.dat"))) {
            oos.writeObject(pedidos);
        }
    }

    public void carregarPedidos() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("pedidos.dat"))) {
            pedidos = (List<Pedido>) ois.readObject();
        } catch (FileNotFoundException e) {
            pedidos = new ArrayList<>();
        }
    }
}
