package com.michellotiago.Controller;

import com.michellotiago.model.dao.ClienteDAO;
import com.michellotiago.model.Cliente;
import com.michellotiago.view.CadastrarClienteView;

/**
 * @author $ {USER}
 **/
public class CadastrarClienteController {
    private CadastrarClienteView cuv;
    private Cliente cliente;
    private ClienteDAO cDAO;

    public CadastrarClienteController(){

        cuv = new CadastrarClienteView();
        cliente = cuv.cadastrarCliente();
        cDAO = new ClienteDAO();
        cDAO.inserirCliente(cliente);
    }
}
