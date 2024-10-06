package com.michellotiago.Controller;

import com.michellotiago.model.dao.ClienteDAO;
import com.michellotiago.model.Cliente;
import com.michellotiago.model.dao.PedidoDAO;
import com.michellotiago.model.Pedido;
import com.michellotiago.model.dao.ProdutoDAO;
import com.michellotiago.model.Produto;
import com.michellotiago.service.Patterns.Decorator.Enderecador;
import com.michellotiago.service.Patterns.Decorator.EnderecadorComBordas;
import com.michellotiago.service.Patterns.Decorator.EnderecadorSimples;
import com.michellotiago.service.Patterns.Decorator.EnderercadorCaixaAlta;
import com.michellotiago.service.Patterns.Observer.*;
import com.michellotiago.service.Patterns.Singleton.Configuration;
import com.michellotiago.service.Patterns.Strategy.ExpressShipping;
import com.michellotiago.service.Patterns.Strategy.NormalShipping;
import com.michellotiago.service.Patterns.Strategy.Order;
import com.michellotiago.service.Patterns.Strategy.Sedex10Shipping;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.michellotiago.lib.Console.limparConsole;
import static java.lang.Thread.sleep;

public class App {
    Scanner scanner = new Scanner(System.in);
    String local;
    String empresa;

    ClienteDAO clientes = new ClienteDAO();
    PedidoDAO pedidos = new PedidoDAO();
    ProdutoDAO produtos = new ProdutoDAO();
    //Cliente cliente = new Cliente();


    public static void main(String[] args) {
        App app = new App();
        Cliente cliente = null;
        app.configuracaoRegional();
        app.conectar();
        cliente = app.logar();
        if (cliente!=null) {
            app.observar(cliente);
            app.comprar();
            app.enviar(cliente);
        }
    }

    private void enviar(Cliente cliente) {
        Enderecador enderecador = new EnderecadorSimples();
         enderecador = new EnderercadorCaixaAlta(enderecador);
         enderecador = new EnderecadorComBordas(enderecador);

        String enderecoFormatado = enderecador.preparaEndereco(cliente.getEndereco());

        System.out.println("\n\nA entrega será no seguinte endereço:\n\n");
        System.out.println(enderecoFormatado);
    }

    private void observar(Cliente clente) {
        System.out.println("há um novo produto na Mesbla. Você quer saber qual é? (1) Sim; (0) Não");
        int item;
        String texto="";

        while(true) {
            texto = scanner.nextLine();
            if (texto.isEmpty()) {
                System.out.println("entre com valor O ou 1");
                continue;
            }

            try {
                item = Integer.parseInt(texto.trim());
                if (item==0){ return;}
                if (item==1){ break;}
                System.out.println("entre com valor O ou 1");
                continue;
            } catch (NumberFormatException e) {
                System.out.println("entre com valor O ou 1");
                continue;
            }
        }
        Produto produto = new Produto();
        produto.setId(6);
        produto.setNome("Cinto");;
        produto.setDescricao("Cinto de couro");
        produto.setPeso(0.20f);
        produto.setPreco(120.00f);
        produto.setQuantidade(30);
       // produtos.inserir(produto);
        IObservador observador1 = new ObservadorSistema(1,"http://mesbla.com.br");
        IObservador observador2 = new ObservadorEmail(2,clente.geteMail());

        ISubject subject = new Subject(produto);
        subject.registrarObservador(observador1);
        subject.registrarObservador(observador2);
        subject.notificarTodos();
    }

    public void configuracaoRegional() {
        Configuration instance = Configuration.getInstance();
        local = instance.getProperty("local");
        System.out.println(local);

        empresa = instance.getProperty("loja");
        System.out.println(empresa);
    }

    public void conectar() {
    }

    public Cliente logar() {
        Cliente cliente = null;
        System.out.println("entre com o nome do usuário.");
        String nome = scanner.nextLine();
        System.out.println("entre com a sua senha.");
        String senha = scanner.nextLine();
        //cliente;// =clientes.findByNameAndSenha(nome, senha);
        if (cliente ==null) {
            System.out.println("Usuário não cadastrado ou senha invalida.");
            return null;
        }
        return cliente;
    }

    public void listarProdutos() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("\n\n Os produtos da loja são os seguintes:\n");
        List<Produto> produtos = this.produtos.findAll();
        Pedido pedido = new Pedido();
        for (Produto produto : produtos) {
            System.out.println("item: " + produto.getId() + " - " + produto.getNome() + " - R$" + df.format(produto.getPreco()));
        }
    }

    public void comprar() {
        int item = 0, quantidade = 0;
        DecimalFormat df = new DecimalFormat("#,###.00");
        String nome = "";
        Pedido pedido = new Pedido();
        List<Produto> produtoscompra = new ArrayList<>();
        while (true) {
            limparConsole();
            listarProdutos();
            System.out.println("Entre com produto e quantidade que deseja comprar: [nº do produto] , [quantidade] ou -1 para finalizar a seleção");
            nome = scanner.nextLine();
            if (nome.equals("-1"))
                break;
            if (nome.isEmpty() || !nome.contains(",")) {
                System.out.println("Entre com produto e quantidade que deseja comprar: [nº do produto] , [quantidade] ou -1 para finalizar a seleção");
                continue;
            }
            try {
                item = Integer.parseInt(nome.substring(0, nome.indexOf(',')).trim());
            } catch (NumberFormatException e) {
                System.out.println("entre com valor de item inteiro");
                continue;
            }
            try {
                quantidade = Integer.parseInt(nome.substring(nome.indexOf(',') + 1).trim());
            } catch (NumberFormatException e) {
                System.out.println("entre com valor de quantidade inteiro");
                continue;
            }
            Produto produtoPedido;
            produtoPedido = produtos.findByIDAndQuatidade(item, quantidade);
            if ((produtoPedido != null) && (produtoscompra.size() > 0)) {
                boolean existe = false;
                for (Produto produtosSelecionado : produtoscompra) {
                    if (produtosSelecionado.getId() == produtoPedido.getId()) {
                        Produto novoProduto = new Produto();
                        novoProduto.setId(produtoPedido.getId());
                        novoProduto.setNome(produtoPedido.getNome());
                        novoProduto.setQuantidade(quantidade);
                        novoProduto.setDescricao(produtoPedido.getDescricao());
                        novoProduto.setPreco(produtoPedido.getPreco());
                        novoProduto.setPeso(produtoPedido.getPeso());
                        produtoscompra.set(produtoscompra.indexOf(produtosSelecionado), novoProduto);
                        existe = true;
                        break;
                    }
                }
                if (!existe) {
                    Produto novoProduto = new Produto();
                    novoProduto.setId(produtoPedido.getId());
                    novoProduto.setNome(produtoPedido.getNome());
                    novoProduto.setQuantidade(quantidade);
                    novoProduto.setDescricao(produtoPedido.getDescricao());
                    novoProduto.setPreco(produtoPedido.getPreco());
                    novoProduto.setPeso(produtoPedido.getPeso());
                    produtoscompra.add(novoProduto);
                }
            } else {
                if (produtoPedido != null) {
                    Produto novoProduto = new Produto();
                    novoProduto.setId(produtoPedido.getId());
                    novoProduto.setNome(produtoPedido.getNome());
                    novoProduto.setQuantidade(quantidade);
                    novoProduto.setDescricao(produtoPedido.getDescricao());
                    novoProduto.setPreco(produtoPedido.getPreco());
                    novoProduto.setPeso(produtoPedido.getPeso());
                    produtoscompra.add(novoProduto);
                }
            }
            System.out.println("Sua seleção de Compra até agora é a seguinte: ");
            for (Produto produto : produtoscompra) {
                System.out.println("Item " + produto.getId() + ", quantidade " + produto.getQuantidade());
            }
        }
        finalizarCompra(produtoscompra);
    }

    public void finalizarCompra(List<Produto> produtosCompra) {
        int tipo = 0;
        DecimalFormat df = new DecimalFormat("#,###.00");

        do {
            System.out.println("\nEscolha o tipo de frete:\n");
            System.out.println("\t(1) - Normal (5 dias)");
            System.out.println("\t(2) - Expresso (2 dias)");
            System.out.println("\t(3) - Sedex 10 (1 dia)");
            try {
                tipo = scanner.nextInt();
            } catch (NumberFormatException e) {
                System.out.println("entre com valor de item inteiro");
                continue;
            }
            if (tipo < 4 || tipo > 0)
                break;
        } while (true);
        Order order = null;
        float peso = 0;
        for (Produto produto : produtosCompra) {
            peso += produto.getQuantidade() * produto.getPeso();
        }
        switch (tipo) {
            case 1:
                order = new Order(peso, new NormalShipping());
                break;
            case 2:
                order = new Order(peso, new ExpressShipping());
                break;
            case 3:
                order = new Order(peso, new Sedex10Shipping());
                break;
        }
        double frete = 10 * order.calculateShipping();
        System.out.println("O valor do frete, para o peso de " + peso + "kg é o seguinte: R$" +
                df.format(frete));

        double valor = 0f;
        for (Produto produto : produtosCompra) {
            valor += produto.getQuantidade() * produto.getPreco();
            System.out.println("Produto " + produto.getNome() + " - preço unitário R$" + df.format(produto.getPreco())
                    + " - subtotal R$" + df.format(produto.getPreco()* produto.getQuantidade()));
        }
           System.out.println("\n O valor total da Compra é: R$" + df.format(valor + frete));
    }
}