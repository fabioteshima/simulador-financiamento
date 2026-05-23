package br.com.teshima.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "memoria_de_calculo")
public class MemoriaDeCalculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate data;
    private BigDecimal valorInicial;
    private BigDecimal valorJurosMes;
    private BigDecimal valorSaldoFinalMes;

    @ManyToOne
    @JoinColumn(name = "financiamento_id")
    Financiamento financiamento;

    public MemoriaDeCalculo(){
    }

    public MemoriaDeCalculo(LocalDate data, BigDecimal valorInicial, BigDecimal valorJurosMes, BigDecimal valorSaldoFinalMes) {
        this.data = data;
        this.valorInicial = valorInicial;
        this.valorJurosMes = valorJurosMes;
        this.valorSaldoFinalMes = valorSaldoFinalMes;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorJurosMes() {
        return valorJurosMes;
    }

    public void setValorJurosMes(BigDecimal valorJurosMes) {
        this.valorJurosMes = valorJurosMes;
    }

    public BigDecimal getValorSaldoFinalMes() {
        return valorSaldoFinalMes;
    }

    public void setValorSaldoFinalMes(BigDecimal valorSaldoFinalMes) {
        this.valorSaldoFinalMes = valorSaldoFinalMes;
    }

    @Override
    public String toString() {
        return  "\n data=" + data +
                "\n valorInicial=" + valorInicial +
                "\n valorJurosMes=" + valorJurosMes +
                "\n valorSaldoFinalMes=" + valorSaldoFinalMes +
                "\n";
    }
}

