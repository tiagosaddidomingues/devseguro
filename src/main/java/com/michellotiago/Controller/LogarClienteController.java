package com.michellotiago.Controller;

import com.michellotiago.model.Cliente;
import com.michellotiago.model.dao.ClienteDAO;
import com.michellotiago.util.Seguranca;
import com.michellotiago.view.LogarClienteView;

public class LogarClienteController {
    private LogarClienteView logarClienteView;
    private ClienteDAO clienteDAO;

    public LogarClienteController() {
        this.clienteDAO = new ClienteDAO();
        this.logarClienteView = new LogarClienteView();
    }

    public Cliente encontrarUsuario() {
        Cliente cliente = logarClienteView.logarCliente();

        // Autentica o cliente utilizando o metodo do ClienteDAO
        Cliente clienteAutenticado = clienteDAO.findByNameAndSenha(cliente.getNome(), cliente.getSenha());

        if (clienteAutenticado != null) {
            System.out.println("Login bem-sucedido!");
            return clienteAutenticado;
        } else {
            System.out.println("Falha no login. Verifique suas credenciais.");
            return null;
        }
    }
}
