package com.michellotiago.service.Patterns.Observer;

import com.michellotiago.entity.Produto;

public class ObservadorSistema implements IObservador {

    public int id;
    public String link;

    public ObservadorSistema(int id , String link){
        this.id = id;
        this.link=link;}
    @Override
    public void update(Produto produto) { System.out.println("Novo produto " + produto.getNome()
            + " no link " + link);}
}
