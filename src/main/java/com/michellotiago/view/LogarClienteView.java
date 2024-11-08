package com.michellotiago.view;

import com.michellotiago.model.Cliente;
import java.util.Scanner;

public class LogarClienteView {
    private Scanner sc;

    public LogarClienteView() {
        this.sc = new Scanner(System.in);
    }

    public Cliente logarCliente() {
        System.out.print("Entre com o nome do usuário: ");
        String nome = sc.nextLine();
        System.out.print("Entre com a sua senha: ");
        String senha = sc.nextLine();

        // Cria um cliente com nome e senha inseridos e retorna para autenticação
        return new Cliente(nome, senha);
    }
}
