package com.michellotiago.service.Patterns.Decorator;

public class EnderecadorComBordas implements Enderecador{
    Enderecador enderecador;
    public EnderecadorComBordas(Enderecador enderecador) {
        super();
        this.enderecador = enderecador;
    }

    @Override

    public String preparaEndereco(String endereco) {
        String enderecoFinal = enderecador.preparaEndereco(endereco);
        StringBuilder formato = new StringBuilder("------------------------\n");
        enderecoFinal.lines().forEach(l-> formato.append("|" + l +"\n" ));
        formato.append("__________________________");

        return formato.toString();
    }
}
