package com.projectstore.rtdias3d.dtoS;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

public class PedidoDTO {

    @NotNull
    private Integer clienteId;

    @NotNull
    private LocalDate dataPedido;

    @NotNull
    private LocalDate prazoEntrega;

    @NotNull
    private String status;

    @NotNull
    private Double valorTotal;

    public PedidoDTO() {
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDate getPrazoEntrega() {
        return prazoEntrega;
    }

    public void setPrazoEntrega(LocalDate prazoEntrega) {
        this.prazoEntrega = prazoEntrega;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
