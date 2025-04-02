package service;

import java.util.ArrayList;
import java.util.List;

public class ItemDoPedido {

    private Integer quantidade;
    private Double preco;
    private Produto produto;

    public ItemDoPedido() {
    }

    public ItemDoPedido(Integer quantidade, Double preco, Produto produto) {
        this.quantidade = quantidade;
        this.preco = preco;
        this.produto = produto;
    }

    public Double subTotal() {
        double subTotal = preco * quantidade;
        return subTotal;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return produto.getNomeDoProduto() +
                ", " + getPreco() + "R$ " +
                ", Quantidade: " + getQuantidade() + ", " +
                "Subtotal :" + subTotal() + "R$";
    }
}
