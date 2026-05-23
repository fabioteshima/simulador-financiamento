package br.com.teshima.unitario;

import br.com.teshima.model.Financiamento;
import br.com.teshima.model.MemoriaDeCalculo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MemoriaDeCalculoTest {

    @Test
    void deveRealizarOsSetsCompletosDoObjeto() {
        MemoriaDeCalculo mc = new MemoriaDeCalculo();
        Financiamento financiamento = null;

        mc.setId(1l);
        mc.setData(LocalDate.of(2000, 01, 01));
        mc.setValorInicial(BigDecimal.valueOf(1000));
        mc.setValorJurosMes(BigDecimal.valueOf(2000));
        mc.setValorSaldoFinalMes(BigDecimal.valueOf(3000));
        mc.setFinanciamento(financiamento);

        Assertions.assertEquals(1l, mc.getId());
        Assertions.assertEquals(LocalDate.of(2000, 01, 01), mc.getData());
        Assertions.assertEquals(BigDecimal.valueOf(1000), mc.getValorInicial());
        Assertions.assertEquals(BigDecimal.valueOf(2000), mc.getValorJurosMes());
        Assertions.assertEquals(BigDecimal.valueOf(3000), mc.getValorSaldoFinalMes());
        Assertions.assertNull(mc.getFinanciamento());

    }
}

