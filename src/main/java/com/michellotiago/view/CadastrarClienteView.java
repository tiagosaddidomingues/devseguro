package com.michellotiago.view;

import com.michellotiago.entity.Cliente;

import java.util.Scanner;

/**
 * @author $ {USER}
 **/
public class CadastrarClienteView {
        private Scanner sc;

        public CadastrarClienteView() {
            this.sc = new Scanner(System.in);
        }

        public Cliente cadastrarCliente(){
            System.out.println("*** CADASTRAR USUÁRIO ****");
            System.out.print("Nome: ");
            String nome = sc.nextLine();
            System.out.print("Senha: ");
            String senha = sc.nextLine();
            return new Cliente(nome, senha);
        }
    }

