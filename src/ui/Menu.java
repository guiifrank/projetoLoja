package ui;

import model.*;
import service.*;
import java.io.*;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private FornecedorService fornecedorService;
    private ProdutoService produtoService;
    private EstoqueService estoqueService;
    private ClienteService clienteService;
    private PedidoService pedidoService;

    public Menu() {
        fornecedorService = new FornecedorService();
        produtoService = new ProdutoService();
        estoqueService = new EstoqueService();
        clienteService = new ClienteService();
        pedidoService = new PedidoService();
        carregarDados(); //excluir comentario
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1. Cadastro de Fornecedores");
            System.out.println("2. Cadastro de Produtos");
            System.out.println("3. Manutenção de Estoque");
            System.out.println("4. Cadastro de Clientes");
            System.out.println("5. Realizar Pedido");
            System.out.println("6. Consultar Pedido");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    menuFornecedores();
                    break;
                case 2:
                    menuProdutos();
                    break;
                case 3:
                    menuEstoque();
                    break;
                case 4:
                    menuClientes();
                    break;
                case 5:
                    menuRealizarPedido();
                    break;
                case 6:
                    menuConsultarPedido();
                    break;
                case 0:
                    salvarDados();
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void menuFornecedores() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Cadastro de Fornecedores:");
            System.out.println("1. Adicionar Fornecedor");
            System.out.println("2. Atualizar Fornecedor");
            System.out.println("3. Remover Fornecedor");
            System.out.println("4. Consultar Fornecedor por ID");
            System.out.println("5. Consultar Fornecedor por Nome");
            System.out.println("6. Alterar elemento de Fornecedor");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarFornecedor();
                    break;
                case 2:
                    atualizarFornecedor();
                    break;
                case 3:
                    removerFornecedor();
                    break;
                case 4:
                    consultarFornecedorPorId();
                    break;
                case 5:
                    consultarFornecedorPorNome();
                    break;
                case 6:
                    menuAtualizarElemento();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarFornecedor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();

        Fornecedor fornecedor = new Fornecedor();
        fornecedor.setNome(nome);
        fornecedor.setDescricao(descricao);
        fornecedor.setTelefone(telefone);
        fornecedor.setEmail(email);

        fornecedorService.adicionarFornecedor(fornecedor);
        System.out.println("Fornecedor adicionado com sucesso.");
    }

    private void atualizarFornecedor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Fornecedor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Fornecedor fornecedor = fornecedorService.consultarFornecedorPorId(id);

        if (fornecedor != null) {
            System.out.print("Novo Nome (atual: " + fornecedor.getNome() + "): ");
            String nome = scanner.nextLine();
            System.out.print("Nova Descrição (atual: " + fornecedor.getDescricao() + "): ");
            String descricao = scanner.nextLine();
            System.out.print("Novo Telefone (atual: " + fornecedor.getTelefone() + "): ");
            String telefone = scanner.nextLine();
            System.out.print("Novo Email (atual: " + fornecedor.getEmail() + "): ");
            String email = scanner.nextLine();

            fornecedor.setNome(nome);
            fornecedor.setDescricao(descricao);
            fornecedor.setTelefone(telefone);
            fornecedor.setEmail(email);

            fornecedorService.atualizarFornecedor(fornecedor);
            System.out.println("Fornecedor atualizado com sucesso.");
        } else {
            System.out.println("Fornecedor não encontrado.");
        }
    }

    private void removerFornecedor() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Fornecedor: ");
        int id = scanner.nextInt();
        fornecedorService.removerFornecedor(id);
    }

    private void consultarFornecedorPorId() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Fornecedor: ");
        int id = scanner.nextInt();
        Fornecedor fornecedor = fornecedorService.consultarFornecedorPorId(id);

        if (fornecedor != null) {
            System.out.println("Fornecedor encontrado: " + fornecedor.getNome());
        } else {
            System.out.println("Fornecedor não encontrado.");
        }
    }

    private void consultarFornecedorPorNome() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Fornecedor: ");
        String nome = scanner.nextLine();
        List<Fornecedor> fornecedores = fornecedorService.consultarFornecedorPorNome(nome);

        if (!fornecedores.isEmpty()) {
            for (Fornecedor fornecedor : fornecedores) {
                System.out.println("Fornecedor encontrado: " + fornecedor.getNome());
            }
        } else {
            System.out.println("Nenhum fornecedor encontrado.");
        }
    }

    private void menuProdutos() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Cadastro de Produtos:");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Consultar Produto por ID");
            System.out.println("5. Consultar Produto por Nome");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    atualizarProduto();
                    break;
                case 3:
                    removerProduto();
                    break;
                case 4:
                    consultarProdutoPorId();
                    break;
                case 5:
                    consultarProdutoPorNome();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("ID do Fornecedor: ");
        int fornecedorId = scanner.nextInt();

        Fornecedor fornecedor = fornecedorService.consultarFornecedorPorId(fornecedorId);
        if (fornecedor == null) {
            System.out.println("Fornecedor não encontrado.");
            return;
        }

        Produto produto = new Produto();
        produto.setNome(nome);
        produto.setDescricao(descricao);
        produto.setFornecedor(fornecedor);

        produtoService.adicionarProduto(produto);
        System.out.println("Produto adicionado com sucesso.");
    }

    private void atualizarProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Produto produto = produtoService.consultarProdutoPorId(id);

        if (produto != null) {
            System.out.print("Novo Nome (atual: " + produto.getNome() + "): ");
            String nome = scanner.nextLine();
            System.out.print("Nova Descrição (atual: " + produto.getDescricao() + "): ");
            String descricao = scanner.nextLine();
            System.out.print("ID do novo Fornecedor (atual: " + produto.getFornecedor().getId() + "): ");
            int fornecedorId = scanner.nextInt();

            Fornecedor fornecedor = fornecedorService.consultarFornecedorPorId(fornecedorId);
            if (fornecedor == null) {
                System.out.println("Fornecedor não encontrado.");
                return;
            }

            produto.setNome(nome);
            produto.setDescricao(descricao);
            produto.setFornecedor(fornecedor);

            produtoService.atualizarProduto(produto);
            System.out.println("Produto atualizado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void removerProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();
        produtoService.removerProduto(id);
    }

    private void consultarProdutoPorId() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Produto: ");
        int id = scanner.nextInt();
        Produto produto = produtoService.consultarProdutoPorId(id);

        if (produto != null) {
            System.out.println("Produto encontrado: " + produto.getNome());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private void consultarProdutoPorNome() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Produto: ");
        String nome = scanner.nextLine();
        List<Produto> produtos = produtoService.consultarProdutoPorNome(nome);

        if (!produtos.isEmpty()) {
            for (Produto produto : produtos) {
                System.out.println("Produto encontrado: " + produto.getNome());
            }
        } else {
            System.out.println("Nenhum produto encontrado.");
        }
    }

    private void menuEstoque() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Manutenção de Estoque:");
            System.out.println("1. Adicionar Estoque");
            System.out.println("2. Atualizar Estoque");
            System.out.println("3. Remover Estoque");
            System.out.println("4. Consultar Estoque por ID");
            System.out.println("5. Consultar Estoque por Produto");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarEstoque();
                    break;
                case 2:
                    atualizarEstoque();
                    break;
                case 3:
                    removerEstoque();
                    break;
                case 4:
                    consultarEstoquePorId();
                    break;
                case 5:
                    consultarEstoquePorProduto();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarEstoque() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Produto: ");
        int produtoId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Quantidade: ");
        int quantidade = scanner.nextInt();
        System.out.print("Preço: ");
        double preco = scanner.nextDouble();

        Produto produto = produtoService.consultarProdutoPorId(produtoId);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        Estoque estoque = new Estoque();
        estoque.setProduto(produto);
        estoque.setQuantidade(quantidade);
        estoque.setPreco(preco);

        estoqueService.adicionarEstoque(estoque);
        System.out.println("Estoque adicionado com sucesso.");
    }

    private void atualizarEstoque() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Estoque: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Estoque estoque = estoqueService.consultarEstoquePorId(id);

        if (estoque != null) {
            System.out.print("Nova Quantidade (atual: " + estoque.getQuantidade() + "): ");
            int quantidade = scanner.nextInt();
            System.out.print("Novo Preço (atual: " + estoque.getPreco() + "): ");
            double preco = scanner.nextDouble();

            estoque.setQuantidade(quantidade);
            estoque.setPreco(preco);

            estoqueService.atualizarEstoque(estoque);
            System.out.println("Estoque atualizado com sucesso.");
        } else {
            System.out.println("Estoque não encontrado.");
        }
    }

    private void removerEstoque() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Estoque: ");
        int id = scanner.nextInt();
        estoqueService.removerEstoque(id);
        System.out.println("Estoque removido com sucesso.");
    }

    private void consultarEstoquePorId() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Estoque: ");
        int id = scanner.nextInt();
        Estoque estoque = estoqueService.consultarEstoquePorId(id);

        if (estoque != null) {
            System.out.println("Estoque encontrado: Produto - " + estoque.getProduto().getNome() + ", Quantidade - " + estoque.getQuantidade() + ", Preço - " + estoque.getPreco());
        } else {
            System.out.println("Estoque não encontrado.");
        }
    }

    private void consultarEstoquePorProduto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Produto: ");
        int produtoId = scanner.nextInt();
        Produto produto = produtoService.consultarProdutoPorId(produtoId);
        Estoque estoque = estoqueService.consultarEstoquePorProduto(produto);

        if (estoque != null) {
            System.out.println("Estoque encontrado: Produto - " + estoque.getProduto().getNome() + ", Quantidade - " + estoque.getQuantidade() + ", Preço - " + estoque.getPreco());
        } else {
            System.out.println("Estoque não encontrado.");
        }
    }

    private void menuClientes() {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Cadastro de Clientes:");
            System.out.println("1. Adicionar Cliente");
            System.out.println("2. Atualizar Cliente");
            System.out.println("3. Remover Cliente");
            System.out.println("4. Consultar Cliente por ID");
            System.out.println("5. Consultar Cliente por Nome");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    adicionarCliente();
                    break;
                case 2:
                    atualizarCliente();
                    break;
                case 3:
                    removerCliente();
                    break;
                case 4:
                    consultarClientePorId();
                    break;
                case 5:
                    consultarClientePorNome();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 0);
    }

    private void adicionarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Cartão de Crédito: ");
        String cartaoCredito = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Cliente cliente = new Cliente();
        cliente.setNome(nome);
        cliente.setTelefone(telefone);
        cliente.setEmail(email);
        cliente.setCartaoCredito(cartaoCredito);
        cliente.setEndereco(endereco);

        clienteService.adicionarCliente(cliente);
        System.out.println("Cliente adicionado com sucesso.");
    }

    private void atualizarCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = clienteService.consultarClientePorId(id);

        if (cliente != null) {
            System.out.print("Novo Nome (atual: " + cliente.getNome() + "): ");
            String nome = scanner.nextLine();
            System.out.print("Novo Telefone (atual: " + cliente.getTelefone() + "): ");
            String telefone = scanner.nextLine();
            System.out.print("Novo Email (atual: " + cliente.getEmail() + "): ");
            String email = scanner.nextLine();
            System.out.print("Novo Cartão de Crédito (atual: " + cliente.getCartaoCredito() + "): ");
            String cartaoCredito = scanner.nextLine();
            System.out.print("Novo Endereço (atual: " + cliente.getEndereco() + "): ");
            String endereco = scanner.nextLine();

            cliente.setNome(nome);
            cliente.setTelefone(telefone);
            cliente.setEmail(email);
            cliente.setCartaoCredito(cartaoCredito);
            cliente.setEndereco(endereco);

            clienteService.atualizarCliente(cliente);
            System.out.println("Cliente atualizado com sucesso.");
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void removerCliente() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        clienteService.removerCliente(id);
    }

    private void consultarClientePorId() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Cliente: ");
        int id = scanner.nextInt();
        Cliente cliente = clienteService.consultarClientePorId(id);

        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNome());
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private void consultarClientePorNome() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        List<Cliente> clientes = clienteService.consultarClientePorNome(nome);

        if (!clientes.isEmpty()) {
            for (Cliente cliente : clientes) {
                System.out.println("Cliente encontrado: " + cliente.getNome());
            }
        } else {
            System.out.println("Nenhum cliente encontrado.");
        }
    }

    private void menuRealizarPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Cliente: ");
        int clienteId = scanner.nextInt();
        scanner.nextLine();
        Cliente cliente = clienteService.consultarClientePorId(clienteId);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        Pedido pedido = new Pedido();
        pedido.setCliente(cliente);

        char adicionarMais;
        do {
            System.out.print("ID do Produto: ");
            int produtoId = scanner.nextInt();
            scanner.nextLine();
            Produto produto = produtoService.consultarProdutoPorId(produtoId);

            if (produto == null) {
                System.out.println("Produto não encontrado.");
                return;
            }

            System.out.print("Quantidade: ");
            int quantidade = scanner.nextInt();

            Estoque estoque = estoqueService.consultarEstoquePorProduto(produto);

            if (estoque == null || estoque.getQuantidade() < quantidade) {
                System.out.println("Estoque insuficiente.");
                return;
            }

            ItemPedido item = new ItemPedido();
            item.setProduto(produto);
            item.setQuantidade(quantidade);
            item.setPreco(estoque.getPreco());

            pedido.adicionarItem(item);

            System.out.print("Deseja adicionar mais produtos? (S/N): ");
            adicionarMais = scanner.next().charAt(0);
        } while (adicionarMais == 'S' || adicionarMais == 's');

        pedidoService.adicionarPedido(pedido);
        System.out.println("Pedido realizado com sucesso.");
    }

    private void menuConsultarPedido() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Pedido: ");
        int pedidoId = scanner.nextInt();
        Pedido pedido = pedidoService.consultarPedidoPorId(pedidoId);

        if (pedido != null) {
            System.out.println("Pedido encontrado: Cliente - " + pedido.getCliente().getNome());
            for (ItemPedido item : pedido.getItens()) {
                System.out.println("Produto: " + item.getProduto().getNome() + ", Quantidade: " + item.getQuantidade() + ", Preço: " + item.getPreco());
            }
        } else {
            System.out.println("Pedido não encontrado.");
        }
    }
    private void menuAtualizarElemento() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("ID do Fornecedor: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        Fornecedor fornecedor = fornecedorService.consultarFornecedorPorId(id);

        if (fornecedor != null) {
            System.out.println("Fornecedor encontrado: " + fornecedor);
            System.out.println("Escolha o campo a ser atualizado:");
            System.out.println("1. Nome");
            System.out.println("2. Descrição");
            System.out.println("3. Telefone");
            System.out.println("4. Email");
            System.out.print("Opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Novo Nome: ");
                    String novoNome = scanner.nextLine();
                    fornecedor.setNome(novoNome);
                    break;
                case 2:
                    System.out.print("Nova Descrição: ");
                    String novaDescricao = scanner.nextLine();
                    fornecedor.setDescricao(novaDescricao);
                    break;
                case 3:
                    System.out.print("Novo Telefone: ");
                    String novoTelefone = scanner.nextLine();
                    fornecedor.setTelefone(novoTelefone);
                    break;
                case 4:
                    System.out.print("Novo Email: ");
                    String novoEmail = scanner.nextLine();
                    fornecedor.setEmail(novoEmail);
                    break;
                default:
                    System.out.println("Opção inválida.");
                    return;
            }

            fornecedorService.atualizarFornecedor(fornecedor);
            System.out.println("Elemento atualizado com sucesso.");
        } else {
            System.out.println("Fornecedor não encontrado.");
        }
    }

    private void salvarDados() {
        try {
            fornecedorService.salvarFornecedores();
            produtoService.salvarProdutos();
            estoqueService.salvarEstoques();
            clienteService.salvarClientes();
            pedidoService.salvarPedidos();
            System.out.println("Dados salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    private void carregarDados() {
        try {
            fornecedorService.carregarFornecedores();
            produtoService.carregarProdutos();
            estoqueService.carregarEstoques();
            clienteService.carregarClientes();
            pedidoService.carregarPedidos();
            System.out.println("Dados carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados: " + e.getMessage());
        }
    }
}
