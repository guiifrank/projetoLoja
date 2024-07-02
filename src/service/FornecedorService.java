package service;

import model.Fornecedor;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FornecedorService {
    private List<Fornecedor> fornecedores;

    public FornecedorService() {
        fornecedores = new ArrayList<>();
    }

    public void adicionarFornecedor(Fornecedor fornecedor) {
        fornecedores.add(fornecedor);
    }

    public void atualizarFornecedor(Fornecedor fornecedor) {
        Fornecedor fornecedorExistente = consultarFornecedorPorId(fornecedor.getId());
        if (fornecedorExistente != null) {
            fornecedorExistente.setNome(fornecedor.getNome());
            fornecedorExistente.setDescricao(fornecedor.getDescricao());
            fornecedorExistente.setTelefone(fornecedor.getTelefone());
            fornecedorExistente.setEmail(fornecedor.getEmail());
        }
    }

    public void removerFornecedor(int id) {
        Fornecedor fornecedor = consultarFornecedorPorId(id);
        if (fornecedor != null) {
            fornecedores.remove(fornecedor);
        }
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
            if (fornecedor.getNome().contains(nome)) {
                resultado.add(fornecedor);
            }
        }
        return resultado;
    }

    public void salvarFornecedores() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("fornecedores.dat"))) {
            oos.writeObject(fornecedores);
        }
    }

    public void carregarFornecedores() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("fornecedores.dat"))) {
            fornecedores = (List<Fornecedor>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Arquivo não encontrado, iniciar com lista vazia
            fornecedores = new ArrayList<>();
        }
    }
}
