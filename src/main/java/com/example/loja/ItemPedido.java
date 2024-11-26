package com.example.loja;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;


    private int quantidade;
    private BigDecimal precoUnitario;

    // Construtor padrão
    public ItemPedido() {}

    // Construtor com argumentos
    public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.getPreco();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        this.quantidade = quantidade;
    }
    

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    // Método para calcular o subtotal do item (quantidade * preço unitário)
    public BigDecimal calcularSubtotal() {
        return precoUnitario.multiply(new BigDecimal(quantidade));
    }

    @Override
public String toString() {
    return "ItemPedido{" +
            "id=" + id +
            ", produto=" + (produto != null ? produto.getId() : null) +
            ", pedido=" + (pedido != null ? pedido.getId() : null) +
            ", quantidade=" + quantidade +
            ", precoUnitario=" + precoUnitario +
            '}';
}

}
