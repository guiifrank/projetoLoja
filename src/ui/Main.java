package ui;

import model.Endereco;
import model.Fornecedor;
import model.Produto;
import service.EstoqueService;
import service.FornecedorService;
import service.ProdutoService;
import java.util.List;
import java.util.Scanner;

public class Main {
        private static FornecedorService fornecedorService = new FornecedorService();
        private static ProdutoService produtoService = new ProdutoService();
        private static EstoqueService estoqueService = new EstoqueService(produtoService);
        private static Scanner sc = new Scanner(System.in);

        public static void main(String[] args) {
            while (true) {
                exibirMenuPrincipal();
                int opcao = Integer.parseInt(sc.nextLine());
                switch (opcao) {
                    case 1:
                        gerenciarFornecedores();
                        break;
                    case 2:
                        gerenciarProdutos();
                        break;
                    case 3:
                        gerenciarEstoque();
                        break;
                    case 0:
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }

    private static void exibirMenuPrincipal() {
        System.out.println("Menu Principal");
        System.out.println("1. Gerenciar Fornecedores");
        System.out.println("2. Gerenciar Produtos");
        System.out.println("3. Gerenciar Estoque");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void gerenciarFornecedores() {
        while (true) {
            System.out.println("Menu Fornecedores");
            System.out.println("1. Adicionar Fornecedor");
            System.out.println("2. Alterar Fornecedor");
            System.out.println("3. Excluir Fornecedor");
            System.out.println("4. Consultar Fornecedor por ID");
            System.out.println("5. Consultar Fornecedor por Nome");
            System.out.println("6. Listar Fornecedores");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(sc.nextLine());
            switch (opcao) {
                case 1:
                    adicionarFornecedor();
                    break;
                case 2:
                    alterarFornecedor();
                    break;
                case 3:
                    excluirFornecedor();
                    break;
                case 4:
                    consultarFornecedorPorId();
                    break;
                case 5:
                    consultarFornecedorPorNome();
                    break;
                case 6:
                    listarFornecedores();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarFornecedor() {
        System.out.print("ID do Fornecedor: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Descrição: ");
        String descricao = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.println("Endereço do Fornecedor:");
        Endereco endereco = criarEndereco();
        fornecedorService.adicionarFornecedor(new Fornecedor(id, nome, descricao, telefone, email, endereco));
        System.out.println("Fornecedor adicionado com sucesso.");
    }


    private static void alterarFornecedor() {
        List<Fornecedor> fornecedores = fornecedorService.listarFornecedores();
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println(fornecedor);
        }
        System.out.print("ID do Fornecedor a ser alterado: ");
        int id = Integer.parseInt(sc.nextLine());
        Fornecedor fornecedor = fornecedorService.consultarFornecedorPorId(id);
        if (fornecedor == null) {
            System.out.println("Fornecedor não encontrado.");
            return;
        }
        System.out.print("Novo Nome: ");
        fornecedor.setName(sc.nextLine());
        System.out.print("Nova Descrição: ");
        fornecedor.setDescricao(sc.nextLine());
        System.out.print("Novo Telefone: ");
        fornecedor.setTelefone(sc.nextLine());
        System.out.print("Novo Email: ");
        fornecedor.setEmail(sc.nextLine());
        System.out.println("Novo Endereço do Fornecedor:");
        fornecedor.setEndereco(criarEndereco());
        fornecedorService.alterarFornecedor(fornecedor);
        System.out.println("Fornecedor alterado com sucesso.");
    }


    private static void excluirFornecedor() {
        List<Fornecedor> fornecedores = fornecedorService.listarFornecedores();
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println(fornecedor);
        }
        System.out.print("ID do Fornecedor a ser excluído: ");
        int id = Integer.parseInt(sc.nextLine());
        if (fornecedorService.excluirFornecedor(id)) {
            System.out.println("Fornecedor excluído com sucesso.");
        } else {
            System.out.println("Fornecedor não encontrado.");
        }
    }

    private static void consultarFornecedorPorId() {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Fornecedor fornecedor = fornecedorService.consultarFornecedorPorId(id);
        if (fornecedor != null) {
            System.out.println(fornecedor);
        } else {
            System.out.println("Fornecedor não encontrado.");
        }
    }

    private static void consultarFornecedorPorNome() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        List<Fornecedor> fornecedores = fornecedorService.consultarFornecedorPorNome(nome);
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println(fornecedor);
        }
    }

    private static void listarFornecedores() {
        List<Fornecedor> fornecedores = fornecedorService.listarFornecedores();
        for (Fornecedor fornecedor : fornecedores) {
            System.out.println(fornecedor);
        }
    }

    private static void gerenciarProdutos() {
        while (true) {
            System.out.println("Menu Produtos");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Excluir Produto");
            System.out.println("4. Consultar Produto por ID");
            System.out.println("5. Consultar Produto por Nome");
            System.out.println("6. Listar Produtos");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(sc.nextLine());
            switch (opcao) {
                case 1:
                    adicionarProduto();
                    break;
                case 2:
                    alterarProduto();
                    break;
                case 3:
                    excluirProduto();
                    break;
                case 4:
                    consultarProdutoPorId();
                    break;
                case 5:
                    consultarProdutoPorNome();
                    break;
                case 6:
                    listarProdutos();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarProduto() {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Nome: ");
        String name = sc.nextLine();
        System.out.print("ID do Fornecedor: ");
        int fornecedorId = Integer.parseInt(sc.nextLine());
        Fornecedor fornecedor = fornecedorService.consultarFornecedorPorId(fornecedorId);
        if (fornecedor == null) {
            System.out.println("Fornecedor não encontrado.");
            return;
        }
        System.out.println("Descrição: ");
        String descricao = sc.nextLine();
        if (produtoService.adicionarProduto(new Produto(id, name, fornecedor, descricao))) {
            System.out.println("Produto adicionado com sucesso.");
        } else {
            System.out.println("ID já existe. Produto não adicionado.");
        }
    }

    private static void alterarProduto() {
        System.out.print("ID do Produto a ser alterado: ");
        int id = Integer.parseInt(sc.nextLine());
        System.out.print("Novo Nome: ");
        String name = sc.nextLine();
        System.out.print("ID do Fornecedor: ");
        int fornecedorId = Integer.parseInt(sc.nextLine());
        Fornecedor fornecedor = fornecedorService.consultarFornecedorPorId(fornecedorId);
        if (fornecedor == null) {
            System.out.println("Fornecedor não encontrado.");
            return;
        }
        System.out.println("Descrição: ");
        String descricao = sc.nextLine();
        if (produtoService.alterarProduto(new Produto(id, name, fornecedor, descricao))) {
            System.out.println("Produto alterado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void excluirProduto() {
        System.out.print("ID do Produto a ser excluído: ");
        int id = Integer.parseInt(sc.nextLine());
        if (produtoService.excluirProduto(id)) {
            System.out.println("Produto excluído com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void consultarProdutoPorId() {
        System.out.print("ID: ");
        int id = Integer.parseInt(sc.nextLine());
        Produto produto = produtoService.consultarProdutoPorId(id);
        if (produto != null) {
            System.out.println(produto);
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void consultarProdutoPorNome() {
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        List<Produto> produtos = produtoService.consultarProdutoPorNome(nome);
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private static void listarProdutos() {
        List<Produto> produtos = produtoService.listarProdutos();
        for (Produto produto : produtos) {
            System.out.println(produto);
        }
    }

    private static Endereco criarEndereco() {
        System.out.print("Rua: ");
        String rua = sc.nextLine();
        System.out.print("Número: ");
        String numero = sc.nextLine();
        System.out.print("Complemento: ");
        String complemento = sc.nextLine();
        System.out.print("Bairro: ");
        String bairro = sc.nextLine();
        System.out.print("CEP: ");
        String cep = sc.nextLine();
        System.out.print("Cidade: ");
        String cidade = sc.nextLine();
        System.out.print("Estado: ");
        String estado = sc.nextLine();
        return new Endereco(rua, numero, complemento, bairro, cep, cidade, estado);
    }


    private static void gerenciarEstoque() {
        while (true) {
            System.out.println("Menu Estoque");
            System.out.println("1. Adicionar Estoque");
            System.out.println("2. Remover Estoque");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(sc.nextLine());
            switch (opcao) {
                case 1:
                    adicionarEstoque();
                    break;
                case 2:
                    removerEstoque();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void adicionarEstoque() {
        System.out.print("ID do Produto: ");
        int produtoId = Integer.parseInt(sc.nextLine());
        System.out.print("Quantidade a ser adicionada: ");
        int quantidade = Integer.parseInt(sc.nextLine());
        if (estoqueService.adicionarEstoque(produtoId, quantidade)) {
            System.out.println("Estoque adicionado com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }

    private static void removerEstoque() {
        System.out.print("ID do Produto: ");
        int produtoId = Integer.parseInt(sc.nextLine());
        System.out.print("Quantidade a ser removida: ");
        int quantidade = Integer.parseInt(sc.nextLine());
        if (estoqueService.removerEstoque(produtoId, quantidade)) {
            System.out.println("Estoque removido com sucesso.");
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}