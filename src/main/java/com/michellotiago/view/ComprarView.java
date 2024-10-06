package com.michellotiago.view;

import com.michellotiago.model.Pedido;
import com.michellotiago.model.Produto;
import com.michellotiago.model.dao.ClienteDAO;
import com.michellotiago.model.dao.PedidoDAO;
import com.michellotiago.model.dao.ProdutoDAO;
import com.michellotiago.service.Patterns.Strategy.ExpressShipping;
import com.michellotiago.service.Patterns.Strategy.NormalShipping;
import com.michellotiago.service.Patterns.Strategy.Order;
import com.michellotiago.service.Patterns.Strategy.Sedex10Shipping;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static com.michellotiago.lib.Console.limparConsole;

/**
 * @author $ {USER}
 **/
public class ComprarView {
    private Scanner scanner;
    String local;
    String empresa;

    ClienteDAO clienteDAO = new ClienteDAO();
    PedidoDAO pedidoDAO = new PedidoDAO();
    ProdutoDAO produtoDAO = new ProdutoDAO();
    //Cliente cliente = new Cliente();

    public ComprarView() {
        this.scanner = new Scanner(System.in);
    }


    public void listarProdutos() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        System.out.println("\n\n Os produtos da loja são os seguintes:\n");
        List<Produto> produtos = this.produtoDAO.findAll();
        Pedido pedido = new Pedido();
        for (Produto produto : produtos) {
            System.out.println("item: " + produto.getId() + " - " + produto.getNome() + " - R$" + df.format(produto.getPreco()));
        }
    }

    public void opcaoDeMenu() {
        int item = 0, quantidade = 0;
        DecimalFormat df = new DecimalFormat("#,###.00");
        String nome = "";
        Pedido pedido = new Pedido();
        List<Produto> compraprodutos = new ArrayList<>();
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
            produtoPedido = produtoDAO.findByIDAndQuatidade(item, quantidade);
            if ((produtoPedido != null) && (compraprodutos.size() > 0)) {
                boolean existe = false;
                for (Produto produtosSelecionado : compraprodutos) {
                    if (produtosSelecionado.getId() == produtoPedido.getId()) {
                        Produto novoProduto = new Produto();
                        novoProduto.setId(produtoPedido.getId());
                        novoProduto.setNome(produtoPedido.getNome());
                        novoProduto.setQuantidade(quantidade);
                        novoProduto.setDescricao(produtoPedido.getDescricao());
                        novoProduto.setPreco(produtoPedido.getPreco());
                        novoProduto.setPeso(produtoPedido.getPeso());
                        compraprodutos.set(compraprodutos.indexOf(produtosSelecionado), novoProduto);
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
                    compraprodutos.add(novoProduto);
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
                    compraprodutos.add(novoProduto);
                }
            }
            System.out.println("Sua seleção de Compra até agora é a seguinte: ");
            for (Produto produto : compraprodutos) {
                System.out.println("Item " + produto.getId() + ", quantidade " + produto.getQuantidade());
            }
        }
        finalizarCompra(compraprodutos);
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
        pedidoDAO.saveAll(produtosCompra);
    }
}

