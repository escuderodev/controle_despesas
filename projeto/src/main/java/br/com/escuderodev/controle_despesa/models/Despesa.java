package br.com.escuderodev.controle_despesa.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

@Entity(name = "Despesa")
@Table(name = "despesas")
@Getter
@Setter
@ToString
public class Despesa {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDespesa;
    private String descricao;
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private LocalDate dataPagamento;
    @CreationTimestamp
    private Timestamp dataCadastro;
    @UpdateTimestamp
    private Timestamp dataAtualizacao;

    public Despesa(DadosCadastroDespesa dados) {
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.dataVencimento = dados.dataVencimento();
        this.dataPagamento = dados.dataPagamento();
    }

    public Despesa() {
    }

    public void atualizaDados(DadosAtualizaDespesa dados) {
        this.idDespesa = dados.idDespesa();
        this.descricao = dados.descricao();
        this.valor = dados.valor();
        this.dataVencimento = dados.dataVencimento();
        this.dataPagamento = dados.dataPagamento();
    }

    public BigDecimal calculaTotalDespesas(List<Despesa> despesas) {
        BigDecimal totalDespesas = new BigDecimal(0);
        for (int i = 0; i < despesas.size(); i ++) {
            totalDespesas = totalDespesas.add(despesas.get(i).getValor());
        }
        return totalDespesas;
    }

    public BigDecimal calculaTotalPago(List<Despesa> despesas) {
        BigDecimal totalPago = new BigDecimal(0);
        for (int i = 0; i < despesas.size(); i ++) {
            if (despesas.get(i).dataPagamento != null) {
                totalPago = totalPago.add(despesas.get(i).getValor());
            }
        }
        return totalPago;
    }

    public BigDecimal calculaTotalAPagar(List<Despesa> despesas) {

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesas);
        BigDecimal totalPago = despesa.calculaTotalPago(despesas);
        BigDecimal totalDevido = totalDespesas.subtract(totalPago);

        return totalDevido;
    }
}
