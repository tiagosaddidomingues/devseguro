package com.michellotiago.view;

import java.util.Scanner;

public class MenuView {
    private Scanner scanner;

    public MenuView() {
        this.scanner = new Scanner(System.in);
    }

    public int opcaoDeMenu() {
        System.out.println("(1) Cadastrar Novo Cliente");
        System.out.println("(2) Entrar com Cliente Existente");
        System.out.println("(3) Alterar Dados do Cliente");
        System.out.println("(4) Excluir Cliente");
        System.out.println("(5) Comprar Produtos");
        System.out.println("(9) Sair");
        System.out.print("Opção: ");
        return scanner.nextInt();
    }

    public void opcaoInvalida() {
        System.out.println("Opção inválida!");
    }

    public void opcaoSair() {
        System.out.println("Saída do Sistema!");
    }

    public void cadastroRealizado() {
        System.out.println("Cadastro Realizado!");
    }

    public void logSucesso() {
        System.out.println("Login com Sucesso!");
    }

    public void requerLogin() {
        System.out.println("Esta opção requer que você esteja logado!");
    }

    // Novo método para confirmar a exclusão do cliente
    public void exclusaoRealizada() {
        System.out.println("Cliente excluído com sucesso!");
    }
}
