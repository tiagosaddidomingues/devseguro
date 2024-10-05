package com.michellotiago.service.Patterns.Decorator;

public class EnderercadorCaixaAlta implements Enderecador {
    Enderecador enderecador;
    public EnderercadorCaixaAlta(Enderecador enderecador) {
        super();
        this.enderecador = enderecador;
    }

    @Override
    public String preparaEndereco(String endereco) {
        return enderecador.preparaEndereco(endereco).toUpperCase();
    }
}
