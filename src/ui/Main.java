package ui;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite o número correspondente ao que deseja fazer:");
        System.out.println("1) Cadastrar um fornecedor");
        System.out.println("2) Cadastrar um produto");
        System.out.println("3) Gerenciar estoque de produtos");
        System.out.println("4) Sair");

        int opcao = sc.nextInt();

        switch (opcao) {
            case 1: //classe fornecedor vai chamar metodo com outras opcoes
                break;
            case 2: //classe produto chama metodo
                break;
            case 3: //classe estoque chama metodo
                break;
            case 4:
                break;
        }

        sc.close();
    }
}