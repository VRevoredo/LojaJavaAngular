package com.example.loja;

import java.math.BigDecimal;

public class SemDesconto implements Desconto {
    @Override
    public BigDecimal aplicarDesconto(BigDecimal total) {
        return total; // Nenhum desconto aplicado
    }
}
