package com.example.loja;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoBuilder {
    private Long id;
    private Cliente cliente;
    private Date data = new Date();
    private List<ItemPedido> itens = new ArrayList<>();
    private String status = "Novo";

    public PedidoBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public PedidoBuilder withCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public PedidoBuilder withData(Date data) {
        this.data = data;
        return this;
    }

    public PedidoBuilder withItens(List<ItemPedido> itens) {
        this.itens = itens;
        return this;
    }

    public PedidoBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    public Pedido build() {
        Pedido pedido = new Pedido();
        pedido.setId(this.id);
        pedido.setCliente(this.cliente);
        pedido.setData(this.data);
        pedido.setItens(this.itens);
        pedido.setStatus(this.status);
        return pedido;
    }
}
