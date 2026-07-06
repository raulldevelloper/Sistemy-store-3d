public class Pedido {

    private int id;
    private Cliente cliente;
    private ItemPedido[] itens;
    private int quantidadeItens;
    private String status;

    public Pedido(int id, Cliente cliente) {

        this.id = id;
        this.cliente = cliente;
        this.itens = new ItemPedido[100];
        this.quantidadeItens = 0;
        this.status = "EM_IMPRESSAO";
    }

    public void adicionarItem(ItemPedido item) {

        itens[quantidadeItens] = item;
        quantidadeItens++;
    }

    public double calcularTotal() {

        double total = 0;

        for (int i = 0; i < quantidadeItens; i++) {

            total += itens[i].calcularSubtotal();
        }

        return total;
    }

    public void mostrarPedido() {

        System.out.println("\n===== PEDIDO =====");
        System.out.println("Cliente: " + cliente.getNome());

        for (int i = 0; i < quantidadeItens; i++) {

            System.out.println(
                    itens[i].getProduto().getNome()
                            + " | Quantidade: "
                            + itens[i].getQuantidade()
                            + " | Subtotal: R$ "
                            + itens[i].calcularSubtotal());
        }

        System.out.println("---------------------------");
        System.out.println("Total: R$ " + calcularTotal());
        System.out.println("Status: " + status);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
