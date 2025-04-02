package principal;

import classe_enum.StatusDoPedido;
import service.Cliente;
import service.ItemDoPedido;
import service.Pedido;
import service.Produto;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Compra {
    public static void main(String[] args) throws ParseException {
        ItemDoPedido itemDoPedido = new ItemDoPedido();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);

        System.out.println("\n============ ENTRE COM OS DADOS DO CLIENTE =============");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Digite a data de nascimento (DD/MM/AAAA): ");
        String dataNasc = sc.nextLine();
        LocalDate nascimento = LocalDate.parse(dataNasc, dtf);

        Cliente cliente = new Cliente(nome, email, nascimento);


        System.out.print("Entre com o status do pedido: ");
        StatusDoPedido statusDoPedido = StatusDoPedido.valueOf(sc.next().toUpperCase());
        Pedido pedido = new Pedido(statusDoPedido, LocalDateTime.now(), cliente);

        System.out.print("\nQuantos itens terá no pedido? ");
        int numero = sc.nextInt();
        for (int i = 1; i <= numero; i++){
            System.out.println("\nEntre com os dados do " + i + "º item");
            System.out.print("Nome do produto: ");
            sc.nextLine();
            String nomeDoProduto = sc.nextLine();
            System.out.print("Preço do produto(R$): ");
            Double preco = sc.nextDouble();
            Produto produto = new Produto(nomeDoProduto, preco);

            System.out.print("Quantidade: ");
            Integer quantidade = sc.nextInt();
            itemDoPedido = new ItemDoPedido(quantidade, preco, produto);
            pedido.adicionarItem(itemDoPedido);
        }
        System.out.println(pedido);

        sc.close();
    }
}
