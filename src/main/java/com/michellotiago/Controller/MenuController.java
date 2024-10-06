package com.michellotiago.Controller;

import com.michellotiago.view.MenuView;

/**
 * @author $ {USER}
 **/
public class MenuController {
    private MenuView mv;
    private int opcao;
    private CadastrarClienteController cuc;

    public MenuController() {
        opcao = 0;
        mv = new MenuView();
        while (opcao != 9) {
            opcao = mv.opcaoDeMenu();

            switch (opcao) {
                case 1:
                    cuc = new CadastrarClienteController();
                    mv.cadastroRealizado();
                    return;
                case 9:
                    mv.opcaoSair();
                    break;
                default:
                    mv.opcaoInvalida();
            }
        }
    }
}
