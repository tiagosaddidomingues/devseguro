package com.michellotiago.Controller;

import com.michellotiago.view.MenuView;

/**
 * @author $ {USER}
 **/
public class MenuController {
    private MenuView menuView;
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
                    if (logarClienteController != null){
                        menuView.logSucesso();
                        comprarController = new ComprarController();
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
