package com.michellotiago.view;

import com.michellotiago.Controller.LogarClienteController;
import com.michellotiago.model.Cliente;
import com.michellotiago.model.dao.ClienteDAO;

import java.util.Scanner;

/**
 * @author $ {USER}
 **/
public class LogarClienteView {
    LogarClienteController logarClienteController;
    Cliente cliente;
    ClienteDAO clienteDAO;
    private Scanner sc;

    public LogarClienteView() {
        this.sc = new Scanner(System.in);
        clienteDAO = new ClienteDAO();

    }

    public Cliente logarCliente(){
    Cliente cliente = null;
        System.out.println("entre com o nome do usuário.");
    String nome = sc.nextLine();
        System.out.println("entre com a sua senha.");
    String senha = sc.nextLine();
        cliente =clienteDAO.findByNameAndSenha(nome,senha);
        if (cliente ==null) {
        System.out.println("Usuário não cadastrado ou senha invalida.");
        return null;
    }
        return cliente;
}
}
