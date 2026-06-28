import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Catalogo catalogo = new Catalogo();

        // Produtos do catálogo
        catalogo.adicionarProduto(new Produto(1,
                "Chaveiro",
                "Chaveiro personalizado",
                "Impressão 3D",
                "PLA",
                5.00,
                45));

        catalogo.adicionarProduto(new Produto(2,
                "Air Fryer Digital",
                "Air Fryer Digital",
                "Utilidades",
                "N/A",
                350.00,
                0));

        catalogo.adicionarProduto(new Produto(3,
                "Smartwatch",
                "Smartwatch Multifuncional",
                "Utilidades",
                "N/A",
                72.00,
                0));

        // Cadastro do cliente
        System.out.print("Nome do cliente: ");
        String nome = sc.nextLine();

        System.out.print("Telefone: ");
        String telefone = sc.nextLine();

        Cliente cliente = new Cliente(1, nome, telefone);

        Pedido pedido = new Pedido(1, cliente);

        int opcao;

        do {

            catalogo.mostrarCatalogo();

            System.out.println("0 - Finalizar pedido");
            System.out.print("Escolha um produto: ");
            opcao = sc.nextInt();

            if (opcao != 0) {

                Produto produto = catalogo.buscarProduto(opcao);

                if (produto != null) {

                    System.out.print("Quantidade: ");
                    int quantidade = sc.nextInt();

                    ItemPedido item = new ItemPedido(produto, quantidade);

                    pedido.adicionarItem(item);

                } else {

                    System.out.println("Produto não encontrado.");

                }

            }

        } while (opcao != 0);

        pedido.mostrarPedido();

        sc.close();

    }
}