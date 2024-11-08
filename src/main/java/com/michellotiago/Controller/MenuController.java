package com.michellotiago.Controller;

import com.michellotiago.model.Cliente;
import com.michellotiago.view.MenuView;

public class MenuController {
    private MenuView menuView;
    private int opcao;
    private CadastrarClienteController cadastrarClienteController;
    private LogarClienteController logarClienteController;
    private AlterarClienteController alterarClienteController;
    private ExcluirClienteController excluirClienteController;
    private ComprarController comprarController;
    private Cliente cliente = null; // Cliente autenticado é armazenado aqui

    public MenuController() {
        opcao = 0;
        menuView = new MenuView();

        while (opcao != 9) {
            opcao = menuView.opcaoDeMenu();

            switch (opcao) {
                case 1:
                    cadastrarClienteController = new CadastrarClienteController();
                    menuView.cadastroRealizado();
                    break;
                case 2:
                    logarClienteController = new LogarClienteController();
                    cliente = logarClienteController.encontrarUsuario();
                    if (cliente != null) {
                        menuView.logSucesso();
                    }
                    break;
                case 3:
                    if (cliente != null) {
                        alterarClienteController = new AlterarClienteController(cliente);
                    } else {
                        menuView.requerLogin();
                    }
                    break;
                case 4:
                    if (cliente != null) {
                        excluirClienteController = new ExcluirClienteController(cliente.getId());
                        cliente = null; // Logout após exclusão
                        menuView.exclusaoRealizada();
                    } else {
                        menuView.requerLogin();
                    }
                    break;
                case 5:
                    if (cliente != null) {
                        comprarController = new ComprarController(cliente); // Garante o cliente autenticado
                    } else {
                        menuView.requerLogin();
                    }
                    break;
                case 9:
                    menuView.opcaoSair();
                    break;
                default:
                    menuView.opcaoInvalida();
            }
        }
    }
}
