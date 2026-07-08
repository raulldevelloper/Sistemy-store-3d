package com.projectstore.rtdias3d.dtoS;

public class ItemPedidoDTO {

    private Integer pedidoId;
    private Integer produtoId;
    private Integer quantidade;
    private Double preco;

    public ItemPedidoDTO() {
    }

    public ItemPedidoDTO(Integer pedidoId, Integer produtoId, Integer quantidade) {
        this.pedidoId = pedidoId;
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Integer getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Integer pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
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
}
