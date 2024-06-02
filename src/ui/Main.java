package ui;

import model.Fornecedor;
import model.Produto;
import service.EstoqueService;
import service.FornecedorService;
import service.ProdutoService;

import java.util.List;
import java.util.Scanner;

public class Main {
        private static FornecedorService fornecedorManager = new FornecedorService();
        private static ProdutoService produtoManager = new ProdutoService();
        private static EstoqueService estoqueManager = new EstoqueService(produtoManager);
        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            while (true) {
                exibirMenuPrincipal();
                int opcao = Integer.parseInt(scanner.nextLine());
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
                int opcao = Integer.parseInt(scanner.nextLine());
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
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Nome: ");
            String name = scanner.nextLine();
            System.out.print("Descricao: ");
            String descricao = scanner.nextLine();
            System.out.println("Telefone: ");
            String telefone = scanner.nextLine();
            System.out.println("Email: ");
            String email = scanner.nextLine();
            fornecedorManager.adicionarFornecedor(new Fornecedor(id, name, descricao, telefone, email));
        }

        private static void alterarFornecedor() {
            System.out.print("ID do Fornecedor a ser alterado: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Novo Nome: ");
            String name = scanner.nextLine();
            System.out.print("Nova Descricao: ");
            String descricao = scanner.nextLine();
            System.out.println("Novo Telefone: ");
            String telefone = scanner.nextLine();
            System.out.print("Novo Email: ");
            String email = scanner.nextLine();
            fornecedorManager.alterarFornecedor(new Fornecedor(id, name, descricao, telefone, email));
        }

        private static void excluirFornecedor() {
            System.out.print("ID do Fornecedor a ser excluído: ");
            int id = Integer.parseInt(scanner.nextLine());
            fornecedorManager.excluirFornecedor(id);
        }

        private static void consultarFornecedorPorId() {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            Fornecedor fornecedor = fornecedorManager.consultarFornecedorPorId(id).orElse(null);
            if (fornecedor != null) {
                System.out.println(fornecedor);
            } else {
                System.out.println("Fornecedor não encontrado.");
            }
        }

        private static void consultarFornecedorPorNome() {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            List<Fornecedor> fornecedores = fornecedorManager.consultarFornecedorPorNome(nome);
            for (Fornecedor fornecedor : fornecedores) {
                System.out.println(fornecedor);
            }
        }

        private static void listarFornecedores() {
            List<Fornecedor> fornecedores = fornecedorManager.listarFornecedores();
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
                int opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
//                        adicionarProduto();
                        break;
                    case 2:
//                        alterarProduto();
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

//        private static void adicionarProduto() {
//            System.out.print("ID: ");
//            int id = Integer.parseInt(scanner.nextLine());
//            System.out.print("Nome: ");
//            String name = scanner.nextLine();
//            System.out.print("ID do Fornecedor: ");
//            int fornecedorId = Integer.parseInt(scanner.nextLine());
//            Fornecedor fornecedor = fornecedorManager.consultarFornecedorPorId(fornecedorId).orElse(null);
//            if (fornecedor == null) {
//                System.out.println("Fornecedor não encontrado.");
//                return;
//            }
//            System.out.print("Quantidade em Estoque: ");
//            int quantidade = Integer.parseInt(scanner.nextLine());
//            produtoManager.adicionarProduto(new Produto(id, name, fornecedor, quantidade));
//        }

//        private static void alterarProduto() {
//            System.out.print("ID do Produto a ser alterado: ");
//            int id = Integer.parseInt(scanner.nextLine());
//            System.out.print("Novo Nome: ");
//            String nome = scanner.nextLine());
//            System.out.print("ID do Fornecedor: ");
//            int fornecedorId = Integer.parseInt(scanner.nextLine());
//            Fornecedor fornecedor = fornecedorManager.consultarFornecedorPorId(fornecedorId).orElse(null);
//            if (fornecedor == null) {
//                System.out.println("Fornecedor não encontrado.");
//                return;
//            }
//            System.out.print("Quantidade em Estoque: ");
//            int quantidade = Integer.parseInt(scanner.nextLine());
//            produtoManager.alterarProduto(new Produto(id, nome, fornecedor, quantidade));
//        }

        private static void excluirProduto() {
            System.out.print("ID do Produto a ser excluído: ");
            int id = Integer.parseInt(scanner.nextLine());
            produtoManager.excluirProduto(id);
        }

        private static void consultarProdutoPorId() {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            Produto produto = produtoManager.consultarProdutoPorId(id).orElse(null);
            if (produto != null) {
                System.out.println(produto);
            } else {
                System.out.println("Produto não encontrado.");
            }
        }

        private static void consultarProdutoPorNome() {
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            List<Produto> produtos = produtoManager.consultarProdutoPorNome(nome);
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }

        private static void listarProdutos() {
            List<Produto> produtos = produtoManager.listarProdutos();
            for (Produto produto : produtos) {
                System.out.println(produto);
            }
        }

        private static void gerenciarEstoque() {
            while (true) {
                System.out.println("Menu Estoque");
                System.out.println("1. Adicionar Estoque");
                System.out.println("2. Remover Estoque");
                System.out.println("0. Voltar");
                System.out.print("Escolha uma opção: ");
                int opcao = Integer.parseInt(scanner.nextLine());
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
            int produtoId = Integer.parseInt(scanner.nextLine());
            System.out.print("Quantidade a ser adicionada: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            estoqueManager.adicionarEstoque(produtoId, quantidade);
        }

        private static void removerEstoque() {
            System.out.print("ID do Produto: ");
            int produtoId = Integer.parseInt(scanner.nextLine());
            System.out.print("Quantidade a ser removida: ");
            int quantidade = Integer.parseInt(scanner.nextLine());
            estoqueManager.removerEstoque(produtoId, quantidade);
        }
}