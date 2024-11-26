package com.example.loja;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private Desconto desconto;


    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    @Temporal(TemporalType.TIMESTAMP)
    private Date data;    

    private String status;

    // Construtor padrão
    public Pedido() {
        this.data = new Date();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemPedido> getItens() {
        return itens;
    }

    public void setItens(List<ItemPedido> itens) {
        this.itens = itens;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (status == null || status.isEmpty()) {
            throw new IllegalArgumentException("O status não pode ser nulo ou vazio.");
        }
        this.status = status;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public BigDecimal calcularTotal() {
        return itens.stream()
                .map(ItemPedido::calcularSubtotal)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public void setDesconto(Desconto desconto) {
        this.desconto = desconto;
    }

    public BigDecimal calcularTotalComDesconto() {
        BigDecimal total = calcularTotal();
        return desconto != null ? desconto.aplicarDesconto(total) : total;
    }

    @Override
    public String toString() {
        return "Pedido{" +
            "id=" + id +
            ", cliente=" + (cliente != null ? cliente.getId() : null) +
            ", data=" + data +
            ", status='" + status + '\'' +
            ", total=" + calcularTotal() +
            '}';
}

}
