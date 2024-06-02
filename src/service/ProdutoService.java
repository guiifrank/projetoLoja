package service;

import model.Produto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoService {
    private List<Produto> produtos;

    public ProdutoService() {
        this.produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public void alterarProduto(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produto.getId()) {
                produtos.set(i, produto);
                return;
            }
        }
    }

    public void excluirProduto(int id) {
        produtos.removeIf(produto -> produto.getId() == id);
    }

    public Optional<Produto> consultarProdutoPorId(int id) {
        return produtos.stream().filter(produto -> produto.getId() == id).findFirst();
    }

    public List<Produto> consultarProdutoPorNome(String nome) {
        List<Produto> resultado = new ArrayList<>();
        for (Produto produto : produtos) {
            if (produto.getName().equalsIgnoreCase(nome)) {
                resultado.add(produto);
            }
        }
        return resultado;
    }

    public List<Produto> listarProdutos() {
        return produtos;
    }
}
