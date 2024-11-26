package com.example.loja;

import java.math.BigDecimal;
import com.example.loja.Desconto;

public class DescontoPorQuantidade implements Desconto {
    @Override
    public BigDecimal aplicarDesconto(BigDecimal total) {
        return total.multiply(new BigDecimal("0.90")); // 10% de desconto
    }
}