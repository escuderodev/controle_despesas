package br.com.escuderodev.controle_despesa.models;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
    List<Despesa> findAllByDataVencimentoGreaterThanEqualAndDataVencimentoLessThanEqual(LocalDate dataInicial, LocalDate dataFinal);
}
