package com.michellotiago.service.Patterns.Strategy;
/*
-> Descrição do Problema:
        - 	Um e-commerce precisa calcular o frete de suas entregas, que pode
variar significativamente dependendo do método de entrega (e.g.,
                                                           entrega normal, expressa, econômica). Implementar um único método
que lide com todos esses casos pode levar a uma função muito
complexa e difícil de manter.

-> Solução com Strategy:
        -	O padrão Strategy permite definir uma família de algoritmos, encapsular
cada um deles como um objeto e torná-los intercambiáveis. Strategy
permite que o algoritmo varie independentemente dos clientes que o
utilizam.


-> Problema: é necessário usar diversos algoritmos de forma dinâmica
	-	Solução:
        • Declarar uma interface que define um comportamento
		• Declarar uma classe que implementa o uso do comportamento
		• Declarar classes que implementam comportamentos específicos
*/

public interface IShippingStrategy {
    double calculateShippingCost(Order order);
}