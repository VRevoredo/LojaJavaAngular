package com.example.loja;

import java.math.BigDecimal;

public class DescontoFidelidade implements Desconto {
    @Override
    public BigDecimal aplicarDesconto(BigDecimal total) {
        return total.multiply(new BigDecimal("0.95")); // Aplica 5% de desconto
    }
}
