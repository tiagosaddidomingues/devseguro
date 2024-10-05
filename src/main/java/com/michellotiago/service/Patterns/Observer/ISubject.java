package com.michellotiago.service.Patterns.Observer;

public interface ISubject {
    void registrarObservador(IObservador o);
    void removerObservador(IObservador o);
    void removerTodosObservadores();
    void notificarObservador(IObservador observer);
    void notificarTodos();
}