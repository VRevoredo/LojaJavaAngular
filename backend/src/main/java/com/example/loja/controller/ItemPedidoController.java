package com.example.loja.controller;

import com.example.loja.ItemPedido;
import com.example.loja.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-pedido")
public class ItemPedidoController {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @GetMapping
    public List<ItemPedido> listarItensPedido() {
        return itemPedidoRepository.findAll();
    }

    @PostMapping
    public ItemPedido criarItemPedido(@RequestBody ItemPedido itemPedido) {
        return itemPedidoRepository.save(itemPedido);
    }

    @GetMapping("/{id}")
    public ItemPedido buscarItemPedido(@PathVariable Long id) {
        return itemPedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item do Pedido não encontrado"));
    }

    @DeleteMapping("/{id}")
    public void deletarItemPedido(@PathVariable Long id) {
        itemPedidoRepository.deleteById(id);
    }
}
