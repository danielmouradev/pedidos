package service;

public class Produto {

    private String nomeDoProduto;
    private Double preco;

    public Produto(){}

    public Produto(String nomeDoProduto, Double preco){
        this.nomeDoProduto = nomeDoProduto;
        this.preco = preco;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
