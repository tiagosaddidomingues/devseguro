package com.michellotiago.view;

import java.util.Scanner;

public class ExcluirClienteView {
    private Scanner sc;

    public ExcluirClienteView() {
        sc = new Scanner(System.in);
    }

    public int obterIdClienteParaExcluir() {
        System.out.print("Digite o ID do cliente que deseja excluir: ");
        return sc.nextInt();
    }

    public void mostrarMensagemSucesso() {
        System.out.println("Cliente excluído com sucesso!");
    }
}
