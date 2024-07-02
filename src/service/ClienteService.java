package service;

import model.Cliente;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteService {
    private List<Cliente> clientes;

    public ClienteService() {
        clientes = new ArrayList<>();
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void atualizarCliente(Cliente cliente) {
        Cliente clienteExistente = consultarClientePorId(cliente.getId());
        if (clienteExistente != null) {
            clienteExistente.setNome(cliente.getNome());
            clienteExistente.setTelefone(cliente.getTelefone());
            clienteExistente.setEmail(cliente.getEmail());
            clienteExistente.setCartaoCredito(cliente.getCartaoCredito());
            clienteExistente.setEndereco(cliente.getEndereco());
        }
    }

    public void removerCliente(int id) {
        Cliente cliente = consultarClientePorId(id);
        if (cliente != null) {
            clientes.remove(cliente);
        }
    }

    public Cliente consultarClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> consultarClientePorNome(String nome) {
        List<Cliente> resultado = new ArrayList<>();
        for (Cliente cliente : clientes) {
            if (cliente.getNome().contains(nome)) {
                resultado.add(cliente);
            }
        }
        return resultado;
    }

    public void salvarClientes() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("clientes.dat"))) {
            oos.writeObject(clientes);
        }
    }

    public void carregarClientes() throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("clientes.dat"))) {
            clientes = (List<Cliente>) ois.readObject();
        } catch (FileNotFoundException e) {
            // Arquivo não encontrado, iniciar com lista vazia
            clientes = new ArrayList<>();
        }
    }
}
