package com.michellotiago.Controller;

import com.michellotiago.model.dao.ClienteDAO;

public class ExcluirClienteController {
    private ClienteDAO clienteDAO;

    public ExcluirClienteController(int clienteId) {
        clienteDAO = new ClienteDAO();
        clienteDAO.excluirCliente(clienteId);
        System.out.println("Cliente logado foi excluído com sucesso!");
    }
}
