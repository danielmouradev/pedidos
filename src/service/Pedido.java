package service;

import classe_enum.StatusDoPedido;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Pedido {

  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    private LocalDateTime momentoDoPedido;
    private StatusDoPedido status;
    private Cliente cliente;

    List<ItemDoPedido> itens = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(StatusDoPedido status, LocalDateTime momentoDoPedido, Cliente cliente) {
        this.status = status;
        this.momentoDoPedido = momentoDoPedido;
        this.cliente = cliente;
    }

    public void adicionarItem(ItemDoPedido item) {
        itens.add(item);
        System.out.println("Item adicionado com sucesso!");
    }

    public void removerItem(ItemDoPedido item) {
        itens.remove(item);
        System.out.println("Item removido com sucesso!");
    }

    public Double total() {
        double soma = 0.0;
        for (ItemDoPedido item : itens) {
            soma += +item.subTotal();
        }
        return soma;
    }

    public LocalDateTime getMomentoDoPedido() {
        return momentoDoPedido;
    }

    public void setMomentoDoPedido(LocalDateTime momentoDoPedido) {
        this.momentoDoPedido = momentoDoPedido;
    }

    public StatusDoPedido getStatus() {
        return status;
    }

    public void setStatus(StatusDoPedido status) {
        this.status = status;
    }

    @Override
    public String toString() {

        System.out.println("Itens do pedido: ");
        for (ItemDoPedido item : itens) {
            System.out.println(item + "");
        }
        String string = "Total R$: " + total() + "\n" +
                "\n SUMÁRIO DO PEDIDO\n" +
                "Momento do pedido: " + getMomentoDoPedido().format(dtf) + " \n" +
                "Status do pedido: " + getStatus() + " \n" +
                "Cliente: " + cliente.toString();
        return string;
    }
}
