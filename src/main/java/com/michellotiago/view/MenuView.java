package com.michellotiago.view;

import java.util.Scanner;

/**
 * @author $ {USER}
 **/
public class MenuView {
    private Scanner scanner;
    public MenuView() {
        this.scanner = new Scanner(System.in);
    }
    public int opcaoDeMenu(){

        System.out.println("(1) Cadastrar Novo Usuário ");
        System.out.println("(2) Entrar com Usuário existente");
        System.out.println("(9) Sair");
        System.out.print("Opção: ");
        return scanner.nextInt();
    }
    public void opcaoInvalida(){
        System.out.println("Opção inválida!");
    }
    public void opcaoSair(){
        System.out.println("Saida do Sistema!");
    }
    public void cadastroRealizado(){
        System.out.println("Cadastro Realizado!");
    }

    public void logSucesso() {
        System.out.println("Login com Sucesso!");
    }
}
