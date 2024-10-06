package com.michellotiago.view;

import com.michellotiago.model.Cliente;

import java.util.Scanner;

/**
 * @author $ {USER}
 **/
public class LogarClienteView {
    Cliente cliente;
    private Scanner sc;

    public LogarClienteView() {
        this.sc = new Scanner(System.in);
    }

    public Cliente logarCliente(){
    Cliente cliente = null;
        System.out.println("entre com o nome do usuário.");
    String nome = sc.nextLine();
        System.out.println("entre com a sua senha.");
    String senha = sc.nextLine();
        cliente =cliente.findByNameAndSenha(nome, senha);
        if (cliente ==null) {
        System.out.println("Usuário não cadastrado ou senha invalida.");
    }
        return cliente;
}
}
