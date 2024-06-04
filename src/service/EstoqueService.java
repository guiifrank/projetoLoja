package service;

import model.Produto;

public class EstoqueService {
    private ProdutoService produtoService;

    public EstoqueService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public boolean adicionarEstoque(int produtoId, int quantidade) {
        Produto produto = produtoService.consultarProdutoPorId(produtoId);
        if (produto != null) {
            produto.setQuantEstoque(produto.getQuantEstoque() + quantidade);
            produtoService.alterarProduto(produto);
            return true;
        } else {
            System.out.println("Produto não encontrado. Estoque não adicionado.");
            return false;
        }
    }

    public boolean removerEstoque(int produtoId, int quantidade) {
        Produto produto = produtoService.consultarProdutoPorId(produtoId);
        if (produto != null) {
            if (produto.getQuantEstoque() >= quantidade) {
                produto.setQuantEstoque(produto.getQuantEstoque() - quantidade);
                produtoService.alterarProduto(produto);
                return true;
            } else {
                System.out.println("Quantidade em estoque insuficiente. Estoque não removido.");
                return false;
            }
        } else {
            System.out.println("Produto não encontrado. Estoque não removido.");
            return false;
        }
    }
}
