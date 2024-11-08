package com.michellotiago.Controller;

import com.michellotiago.model.Cliente;
import com.michellotiago.view.ComprarView;

public class ComprarController {
    private ComprarView comprarView;

    public ComprarController(Cliente cliente) {
        if (cliente != null) { // Certifica-se de que o cliente está autenticado antes de proceder
            comprarView = new ComprarView(cliente);
            comprarView.opcaoDeMenu();
        } else {
            System.out.println("Erro: cliente não autenticado.");
        }
    }
}
