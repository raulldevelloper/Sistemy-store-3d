public class Catalogo {

    private Produto[] produtos;
    private int quantidadeProdutos;

    public Catalogo() {

        produtos = new Produto[100];
        quantidadeProdutos = 0;
    }

    public void adicionarProduto(Produto produto) {

        produtos[quantidadeProdutos] = produto;
        quantidadeProdutos++;
    }

    public void mostrarCatalogo() {

        System.out.println("\n======= CATÁLOGO =======");

        for (int i = 0; i < quantidadeProdutos; i++) {

            Produto produto = produtos[i];

            System.out.println(
                    produto.getId() + " - " +
                            produto.getNome() +
                            " | R$ " + produto.getPreco());
        }
    }

    public Produto buscarProduto(int id) {

        for (int i = 0; i < quantidadeProdutos; i++) {

            if (produtos[i].getId() == id) {
                return produtos[i];
            }
        }

        return null;
    }
}
