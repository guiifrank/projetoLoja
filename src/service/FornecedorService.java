package service;

import model.Fornecedor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FornecedorService {
    private List<Fornecedor> fornecedores;

    public FornecedorService() {
        this.fornecedores = new ArrayList<>();
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public void alterarFornecedor(Fornecedor fornecedor) {
        for (int i = 0; i < fornecedores.size(); i++) {
            if (fornecedores.get(i).getId() == fornecedor.getId()) {
                fornecedores.set(i, fornecedor);
                return;
            }
        }
    }

    public void excluirFornecedor(int id) {
        fornecedores.removeIf(fornecedor -> fornecedor.getId() == id);
    }

    public Optional<Fornecedor> consultarFornecedorPorId(int id) {
        return fornecedores.stream().filter(fornecedor -> fornecedor.getId() == id).findFirst();
    }

    public List<Fornecedor> consultarFornecedorPorNome(String nome) {
        List<Fornecedor> resultado = new ArrayList<>();
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getName().equalsIgnoreCase(nome)) {
                resultado.add(fornecedor);
            }
        }
        return resultado;
    }

    public List<Fornecedor> listarFornecedores() {
        return fornecedores;
    }
}
