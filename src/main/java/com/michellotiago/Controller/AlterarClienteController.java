package com.michellotiago.Controller;

import com.michellotiago.model.Cliente;
import com.michellotiago.model.dao.ClienteDAO;
import com.michellotiago.view.MenuView;
import java.util.Scanner;

public class AlterarClienteController {
    private ClienteDAO clienteDAO;
    private MenuView menuView;
    private Scanner scanner;

    public AlterarClienteController(Cliente cliente) {
        clienteDAO = new ClienteDAO();
        menuView = new MenuView();
        scanner = new Scanner(System.in);

        System.out.println("** Alteração de Dados do Cliente **");

        System.out.print("Novo Nome (deixe em branco para manter): ");
        String nome = scanner.nextLine();
        if (!nome.isEmpty()) {
            cliente.setNome(nome);
        }

        System.out.print("Nova Senha (deixe em branco para manter): ");
        String senha = scanner.nextLine();
        if (!senha.isEmpty()) {
            cliente.setSenha(senha);
        }

        System.out.print("Novo Email (deixe em branco para manter): ");
        String email = scanner.nextLine();
        if (!email.isEmpty()) {
            cliente.setEmail(email);
        }

        System.out.print("Novo Telefone (deixe em branco para manter): ");
        String telefone = scanner.nextLine();
        if (!telefone.isEmpty()) {
            cliente.setTelefone(telefone);
        }

        System.out.print("Novo Endereço (deixe em branco para manter): ");
        String endereco = scanner.nextLine();
        if (!endereco.isEmpty()) {
            cliente.setEndereco(endereco);
        }

        clienteDAO.atualizarCliente(cliente);
        System.out.println("Dados do cliente atualizados com sucesso!");
    }
}
