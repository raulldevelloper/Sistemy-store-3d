package com.projectstore.rtdias3d.dtoS;

public class ProdutoDTO {

    private String nome;
    private String descricao;
    private String categoria;
    private Double preco;
    private String material;
    private Integer tempoPreparo;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nome, String descricao, String categoria, Double preco, String material, Integer tempoPreparo) {
        this.nome = nome;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
        this.material = material;
        this.tempoPreparo = tempoPreparo;
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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(Integer tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }
}
