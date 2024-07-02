package service;

import model.Produto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoService {
    private List<Produto> produtos;

    public ProdutoService() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void atualizarProduto(Produto produto) {
        Produto produtoExistente = consultarProdutoPorId(produto.getId());
        if (produtoExistente != null) {
            produtoExistente.setNome(produto.getNome());
            produtoExistente.setDescricao(produto.getDescricao());
            produtoExistente.setFoto(produto.getFoto());
            produtoExistente.setFornecedor(produto.getFornecedor());
        }
    }

    public void removerProduto(int id) {
        Produto produto = consultarProdutoPorId(id);
        if (produto != null) {
            produtos.remove(produto);
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Produto nao encontrado.");
        }
    }

    public Produto consultarProdutoPorId(int id) {
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                return produto;
            }
        }
        return null;
    }

    public List<Produto> consultarProdutoPorNome(String nome) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getNome().contains(nome)) {
                resultado.add(produto);
            }
        }
        return resultado;
    }

    public void salvarProdutos() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("produtos.dat"))) {
            oos.writeObject(produtos);
        }
    }

    public void carregarProdutos() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("produtos.dat"))) {
            produtos = (List<Produto>) ois.readObject();
        } catch (FileNotFoundException e) {
            produtos = new ArrayList<>();
        }
    }
}
