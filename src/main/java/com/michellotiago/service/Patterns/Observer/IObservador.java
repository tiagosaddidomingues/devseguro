package com.michellotiago.service.Patterns.Observer;

import com.michellotiago.repository.produto.dto.Produto;

public interface IObservador {
    void update(Produto produto);
}
