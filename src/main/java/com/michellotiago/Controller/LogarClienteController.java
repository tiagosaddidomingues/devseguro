package com.michellotiago.Controller;

import com.michellotiago.model.Cliente;
import com.michellotiago.model.dao.ClienteDAO;
import com.michellotiago.view.CadastrarClienteView;
import com.michellotiago.view.LogarClienteView;

import java.util.Scanner;

/**
 * @author $ {USER}
 **/
public class LogarClienteController {
    private LogarClienteView cuv;
    private Cliente cliente;
    private ClienteDAO cDAO;


    public LogarClienteController(){

        cuv = new LogarClienteView();
        cliente = cuv.logarCliente();
        cDAO = new ClienteDAO();
        cDAO.inserirCliente(cliente);
    }

}
