package service;

import model.Estoque;
import model.Produto;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EstoqueService {
    private List<Estoque> estoques;

    public EstoqueService() {
        estoques = new ArrayList<>();
    }

    public void adicionarEstoque(Estoque estoque) {
        estoques.add(estoque);
    }

    public void atualizarEstoque(Estoque estoque) {
        Estoque estoqueExistente = consultarEstoquePorId(estoque.getId());
        if (estoqueExistente != null) {
            estoqueExistente.setQuantidade(estoque.getQuantidade());
            estoqueExistente.setPreco(estoque.getPreco());
            estoqueExistente.setProduto(estoque.getProduto());
        }
    }

    public void removerEstoque(int id) {
        Estoque estoque = consultarEstoquePorId(id);
        if (estoque != null) {
            estoques.remove(estoque);
            System.out.println("Estoque removido com sucesso!");
        } else {
            System.out.println("Estoque nao encontrado.");
        }
    }

    public Estoque consultarEstoquePorId(int id) {
        for (Estoque estoque : estoques) {
            if (estoque.getId() == id) {
                return estoque;
            }
        }
        return null;
    }

    public Estoque consultarEstoquePorProduto(Produto produto) {
        for (Estoque estoque : estoques) {
            if (estoque.getProduto().equals(produto)) {
                return estoque;
            }
        }
        return null;
    }

    public void salvarEstoques() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("estoques.dat"))) {
            oos.writeObject(estoques);
        }
    }

    public void carregarEstoques() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("estoques.dat"))) {
            estoques = (List<Estoque>) ois.readObject();
        } catch (FileNotFoundException e) {
            estoques = new ArrayList<>();
        }
    }
}
