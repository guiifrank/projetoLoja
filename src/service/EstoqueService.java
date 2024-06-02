package service;

import model.Produto;

import java.util.Optional;

public class EstoqueService {
    private ProdutoService produtoService;

    public EstoqueService(ProdutoService produtoManager) {
        this.produtoService = produtoManager;
    }

    public void adicionarEstoque(int produtoId, int quantidade) {
        Optional<Produto> produtoOpt = produtoService.consultarProdutoPorId(produtoId);
        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            produto.setQuantEstoque(produto.getQuantEstoque() + quantidade);
            produtoService.alterarProduto(produto);
        }
    }

    public void removerEstoque(int produtoId, int quantidade) {
        Optional<Produto> produtoOpt = produtoService.consultarProdutoPorId(produtoId);
        if (produtoOpt.isPresent()) {
            Produto produto = produtoOpt.get();
            produto.setQuantEstoque(produto.getQuantEstoque() - quantidade);
            produtoService.alterarProduto(produto);
        }
    }
}
