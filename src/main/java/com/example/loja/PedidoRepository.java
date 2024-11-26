package com.example.loja;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Adicionando método customizado para buscar pedidos por cliente
    List<Pedido> findByCliente_Id(Long clienteId);
}
