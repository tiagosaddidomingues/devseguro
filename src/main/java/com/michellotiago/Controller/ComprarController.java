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
        opcao = 0;
        comprarView = new ComprarView();
        while (opcao != 9) {
            opcao = comprarView.opcaoDeMenu();

            switch (opcao) {
                case 1:
                    cadastrarClienteController = new CadastrarClienteController();
                    comprarView.cadastroRealizado();
                    return;
                case 2:
                    logarClienteController = new LogarClienteController();
                    if (logarClienteController != null){
                        comprarView.logSucesso();
                        comprarController = new ComprarController();
                    }
                case 9:
                    comprarView.opcaoSair();
                    break;
                default:
                    comprarView.opcaoInvalida();
            }
        }
    }

}

