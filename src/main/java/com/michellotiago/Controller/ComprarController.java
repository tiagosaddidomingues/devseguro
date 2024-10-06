package com.michellotiago.Controller;

import com.michellotiago.view.ComprarView;
import com.michellotiago.view.MenuView;

/**
 * @author $ {USER}
 **/
public class ComprarController {
    private ComprarView comprarView;
    private int opcao;
    private CadastrarClienteController cadastrarClienteController;
    private LogarClienteController logarClienteController;
    private ComprarController comprarController;

    public ComprarController(){
        comprarView = new ComprarView();
        comprarView.opcaoDeMenu();
    }

}

