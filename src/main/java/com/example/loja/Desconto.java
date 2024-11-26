package com.example.loja;

import java.math.BigDecimal;

public interface Desconto {
    /**
     * Aplica um desconto ao valor total fornecido.
     *
     * @param total O valor total ao qual o desconto será aplicado.
     * @return O valor com o desconto aplicado.
     */
    BigDecimal aplicarDesconto(BigDecimal total);
}
