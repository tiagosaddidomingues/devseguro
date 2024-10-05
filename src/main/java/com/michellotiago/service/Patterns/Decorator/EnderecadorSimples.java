package com.michellotiago.service.Patterns.Decorator;

public class EnderecadorSimples implements Enderecador {

    // "SQSW 107 Bloco W Apartamento 1021, Sudoeste, Brasília, DF, 70.998-869"
    @Override
    public String preparaEndereco(String endereco) {
        String enderecoFinal="";
        enderecoFinal = endereco.substring(0, endereco.indexOf(',')).trim() + "\n";
        endereco = endereco.substring(endereco.indexOf(',')+1,endereco.length());

        enderecoFinal = enderecoFinal + endereco.substring(0, endereco.indexOf(',')).trim() + "\n";
        endereco = endereco.substring(endereco.indexOf(',')+1,endereco.length());

        enderecoFinal = enderecoFinal + endereco.substring(0, endereco.indexOf(',')).trim() + "\n";
        endereco = endereco.substring(endereco.indexOf(',')+1,endereco.length());

        enderecoFinal = enderecoFinal + endereco.substring(0, endereco.indexOf(',')).trim() + "\n";
        endereco = endereco.substring(endereco.indexOf(',')+1,endereco.length());

        enderecoFinal = enderecoFinal + endereco.trim();


        return enderecoFinal;
    }
}
