package com.michellotiago.service.Patterns.Observer;

import java.util.ArrayList;
import java.util.List;

import com.michellotiago.entity.Produto;


public class Subject implements ISubject {

    private List<IObservador> observadores = new ArrayList<>();
    private int state;
    private Produto produto;

    public Subject(Produto produto){
        this.produto = produto;
    }
    public void setState(int value){ this.state = state;}

    @Override
    public void registrarObservador(IObservador o) { observadores.add(o);}

    @Override
    public void removerObservador(IObservador o) { observadores.remove(o);}

    @Override
    public void removerTodosObservadores() { this.observadores.removeAll(this.observadores); }

    @Override
    public void notificarObservador(IObservador observador) { observador.update(this.produto); }

    @Override
    public void notificarTodos() { observadores.forEach(this::notificarObservador);
    }
}
