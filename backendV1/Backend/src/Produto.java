public class Produto {

    private int id;
    private String nome;
    private String descricao;
    private String categoria;
    private String material;
    private double preco;
    private int tempoPreparo;

    public Produto(int id, String nome, String descricao, String categoria,
                   String material, double preco, int tempoPreparo) {

        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.material = material;
        this.preco = preco;
        this.tempoPreparo = tempoPreparo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public void mostrarProduto() {

        System.out.println("ID: " + id);
        System.out.println("Produto: " + nome);
        System.out.println("Categoria: " + categoria);
        System.out.println("Material: " + material);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Tempo de preparo: " + tempoPreparo + " minutos");
    }
}
