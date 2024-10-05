package com.michellotiago.service.Patterns.Observer;

import com.michellotiago.repository.produto.dto.Produto;

public class ObservadorEmail implements IObservador {

    public int id;
    public String eMail;
    public ObservadorEmail(int id, String eMail){ this.id = id;this.eMail=eMail;}
    @Override
    public void update(Produto produto) { System.out.println("Enviou para o email " + eMail
            +" informações do novo prdduto" + produto.getNome());
    }
}
