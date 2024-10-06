package com.michellotiago.view;

import java.util.Scanner;

/**
 * @author $ {USER}
 **/
public class MenuView {
    private Scanner sc;
    public MenuView() {
        this.sc = new Scanner(System.in);
    }
    public int opcaoDeMenu(){

        System.out.println("(1) Cadastrar Novo Usuário ");
        System.out.println("(2) Entrar com Usuário existente");
        System.out.println("(9) Sair");
        System.out.print("Opção: ");
        return sc.nextInt();
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
}
