package model;

import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Fornecedor> fornecedores;
    private int nextId;

    public Loja() {
        fornecedores = new ArrayList<Fornecedor>();
        nextId = 1;
    }

    public void incluirFornecedor(Fornecedor fornecedor) {
        fornecedor.setId(nextId++);
        fornecedores.add(fornecedor);
    }

    public void excluirFornecedor(int id) {
        fornecedores.removeIf(fornecedor -> fornecedor.getId() == id);
    }

    public void alterarFornecedor(int id, Fornecedor fornecedorAlterado) {
        Fornecedor fornecedor = consultarFornecedorPorId(id);
        if (fornecedor != null) {
            fornecedor.setName(fornecedorAlterado.getName());
            fornecedor.setDescricao(fornecedorAlterado.getDescricao());
            fornecedor.setTelefone(fornecedorAlterado.getTelefone());
            fornecedor.setEmail(fornecedorAlterado.getEmail());
        } else {
            System.out.println("Fornecedor não encontrado.");
        }
    }

    public Fornecedor consultarFornecedorPorId(int id) {
        return fornecedores.stream()
                .filter(fornecedor -> fornecedor.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }
}
