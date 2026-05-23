package br.com.teshima.unitario;

import br.com.teshima.model.Financiamento;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class FinanciamentoTest {

    @Test
    void deveRealizarOsSetsCompletosDoObjeto(){
        Financiamento financiamentoteste = new Financiamento();
        financiamentoteste.setId(1l);
        financiamentoteste.setValorInicial(BigDecimal.valueOf(1000));
        financiamentoteste.setPrazoMeses(1);
        financiamentoteste.setTaxaJurosMensal(1.0);
        financiamentoteste.setValorTotalJuros(BigDecimal.valueOf(2000));
        financiamentoteste.setValorTotalFinal(BigDecimal.valueOf(3000));

        Assertions.assertEquals(1l, financiamentoteste.getId());
        Assertions.assertEquals(BigDecimal.valueOf(1000), financiamentoteste.getValorInicial());
        Assertions.assertEquals(1, financiamentoteste.getPrazoMeses());
        Assertions.assertEquals(1.0, financiamentoteste.getTaxaJurosMensal());
        Assertions.assertEquals(BigDecimal.valueOf(2000), financiamentoteste.getValorTotalJuros());
        Assertions.assertEquals(BigDecimal.valueOf(3000), financiamentoteste.getValorTotalFinal());
    }
}
