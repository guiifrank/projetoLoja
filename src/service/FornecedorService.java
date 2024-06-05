package service;

import model.Fornecedor;
import java.util.ArrayList;
import java.util.List;

public class FornecedorService {
    private List<Fornecedor> fornecedores;

    public FornecedorService() {
        this.fornecedores = new ArrayList<>();
    }

    public boolean adicionarFornecedor(Fornecedor fornecedor) {
        for (Fornecedor f : fornecedores) {
            if (f.getId() == fornecedor.getId()) {
                return false;
            }
        }
        fornecedores.add(fornecedor);
        return true;
    }

    public boolean alterarFornecedor(Fornecedor fornecedor) {
        for (int i = 0; i < fornecedores.size(); i++) {
            if (fornecedores.get(i).getId() == fornecedor.getId()) {
                fornecedores.set(i, fornecedor);
                return true;
            }
        }
        return false;
    }

    public boolean excluirFornecedor(int id) {
        return fornecedores.removeIf(fornecedor -> fornecedor.getId() == id);
    }

    public Fornecedor consultarFornecedorPorId(int id) {
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getId() == id) {
                return fornecedor;
            }
        }
        return null;
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
