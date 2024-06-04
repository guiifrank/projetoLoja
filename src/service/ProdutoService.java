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

    public boolean adicionarProduto(Produto produto) {
        for (Produto p : produtos) {
            if (p.getId() == produto.getId()) {
                return false;
            }
        }
        produtos.add(produto);
        return true;
    }

    public boolean alterarProduto(Produto produto) {
        for (int i = 0; i < produtos.size(); i++) {
            if (produtos.get(i).getId() == produto.getId()) {
                produtos.set(i, produto);
                return true;
            }
        }
        return false;
    }

    public boolean excluirProduto(int id) {
        return produtos.removeIf(produto -> produto.getId() == id);
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
