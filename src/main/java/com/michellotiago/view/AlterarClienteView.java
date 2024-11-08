package com.michellotiago.view;

import com.michellotiago.model.Cliente;

import java.util.Scanner;

public class AlterarClienteView {
    private Scanner sc;

    public AlterarClienteView() {
        sc = new Scanner(System.in);
    }

    public Cliente obterDadosCliente() {
        System.out.print("Digite o ID do cliente que deseja alterar: ");
        int id = sc.nextInt();
        sc.nextLine(); // Limpa o buffer
        System.out.print("Novo Nome: ");
        String nome = sc.nextLine();
        System.out.print("Nova Senha: ");
        String senha = sc.nextLine();
        System.out.print("Novo e-mail: ");
        String email = sc.nextLine();
        System.out.print("Novo telefone: ");
        String telefone = sc.nextLine();
        System.out.print("Novo endereço: ");
        String endereco = sc.nextLine();

        Cliente cliente = new Cliente(nome, senha);
        cliente.setId(id);
        cliente.setEmail(email);
        cliente.setTelefone(telefone);
        cliente.setEndereco(endereco);
        return cliente;
    }

    public void mostrarMensagemSucesso() {
        System.out.println("Cliente alterado com sucesso!");
    }
}
