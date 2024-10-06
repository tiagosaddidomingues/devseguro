package com.michellotiago.Controller;

import com.michellotiago.model.Cliente;
import com.michellotiago.view.LogarClienteView;
import com.michellotiago.view.MenuView;

/**
 * @author $ {USER}
 **/
public class MenuController {
    private MenuView menuView;
    LogarClienteView logarClienteView;
    private int opcao;
    private CadastrarClienteController cadastrarClienteController;
    private LogarClienteController logarClienteController;
    private ComprarController comprarController;

    public MenuController() {
        opcao = 0;
        menuView = new MenuView();
        while (opcao != 9) {
            opcao = menuView.opcaoDeMenu();

            switch (opcao) {
                case 1:
                    cadastrarClienteController = new CadastrarClienteController();
                    menuView.cadastroRealizado();
                    return;
                case 2:
                    logarClienteController = new LogarClienteController();
                    Cliente cliente = logarClienteController.encontrarUsuario();
                    if (cliente != null){
                        menuView.logSucesso();
                        comprarController = new ComprarController(cliente);
                    }

                case 9:
                    menuView.opcaoSair();
                    break;
                default:
                    menuView.opcaoInvalida();
            }
        }
    }
}
