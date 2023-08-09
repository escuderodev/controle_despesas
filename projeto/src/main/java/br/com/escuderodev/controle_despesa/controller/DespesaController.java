package br.com.escuderodev.controle_despesa.controller;

import br.com.escuderodev.controle_despesa.models.DadosAtualizaDespesa;
import br.com.escuderodev.controle_despesa.models.DadosCadastroDespesa;
import br.com.escuderodev.controle_despesa.models.Despesa;
import br.com.escuderodev.controle_despesa.models.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaRepository repository;

    @GetMapping("formulario")
    public String carregarFormularioCadastro(Long id, Model model) {
        if (id != null) {
            var despesa = repository.getReferenceById(id);
            model.addAttribute("despesa", despesa);
        }
        return "despesa/formulario";
    }

    @GetMapping
    public String carregarListagemDespesas(Model model) {
        List<Despesa> despesas = repository.findAll();
        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesas);
        BigDecimal totalPago = despesa.calculaTotalPago(despesas);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesas);

        model.addAttribute("listaDeDespesas", despesas);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @GetMapping("/janeiro")
    public String carregarListagemDespesasJaneiro(Model model) {
        List<Despesa> despesas = repository.findAll();
        List<Despesa> despesasJaneiro = new ArrayList<>();
        int mes;

        for (int i = 0; i < despesas.size(); i++) {
            mes = despesas.get(i).getDataVencimento().getMonthValue();

            if (mes == 1) {
                despesasJaneiro.add(despesas.get(i));
            }
        }

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesasJaneiro);
        BigDecimal totalPago = despesa.calculaTotalPago(despesasJaneiro);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesasJaneiro);

        model.addAttribute("listaDeDespesas", despesasJaneiro);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @GetMapping("/fevereiro")
    public String carregarListagemDespesasFevereiro(Model model) {
        List<Despesa> despesas = repository.findAll();
        List<Despesa> despesasFevereiro = new ArrayList<>();
        int mes;

        for (int i = 0; i < despesas.size(); i++) {
            mes = despesas.get(i).getDataVencimento().getMonthValue();

            if (mes == 2) {
                despesasFevereiro.add(despesas.get(i));
            }
        }

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesasFevereiro);
        BigDecimal totalPago = despesa.calculaTotalPago(despesasFevereiro);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesasFevereiro);

        model.addAttribute("listaDeDespesas", despesasFevereiro);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @GetMapping("/marco")
    public String carregarListagemDespesasMarco(Model model) {
        List<Despesa> despesas = repository.findAll();
        List<Despesa> despesasMarco = new ArrayList<>();
        int mes;

        for (int i = 0; i < despesas.size(); i++) {
            mes = despesas.get(i).getDataVencimento().getMonthValue();

            if (mes == 3) {
                despesasMarco.add(despesas.get(i));
            }
        }

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesasMarco);
        BigDecimal totalPago = despesa.calculaTotalPago(despesasMarco);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesasMarco);

        model.addAttribute("listaDeDespesas", despesasMarco);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @GetMapping("/abril")
    public String carregarListagemDespesasAbril(Model model) {
        List<Despesa> despesas = repository.findAll();
        List<Despesa> despesasAbril = new ArrayList<>();
        int mes;

        for (int i = 0; i < despesas.size(); i++) {
            mes = despesas.get(i).getDataVencimento().getMonthValue();

            if (mes == 4) {
                despesasAbril.add(despesas.get(i));
            }
        }

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesasAbril);
        BigDecimal totalPago = despesa.calculaTotalPago(despesasAbril);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesasAbril);

        model.addAttribute("listaDeDespesas", despesasAbril);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @GetMapping("/maio")
    public String carregarListagemDespesasMaio(Model model) {
        List<Despesa> despesas = repository.findAll();
        List<Despesa> despesasMaio = new ArrayList<>();
        int mes;

        for (int i = 0; i < despesas.size(); i++) {
            mes = despesas.get(i).getDataVencimento().getMonthValue();

            if (mes == 5) {
                despesasMaio.add(despesas.get(i));
            }
        }

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesasMaio);
        BigDecimal totalPago = despesa.calculaTotalPago(despesasMaio);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesasMaio);

        model.addAttribute("listaDeDespesas", despesasMaio);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @GetMapping("/junho")
    public String carregarListagemDespesasJunho(Model model) {
        List<Despesa> despesas = repository.findAll();
        List<Despesa> despesasJunho = new ArrayList<>();
        int mes;

        for (int i = 0; i < despesas.size(); i++) {
            mes = despesas.get(i).getDataVencimento().getMonthValue();

            if (mes == 6) {
                despesasJunho.add(despesas.get(i));
            }
        }

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesasJunho);
        BigDecimal totalPago = despesa.calculaTotalPago(despesasJunho);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesasJunho);

        model.addAttribute("listaDeDespesas", despesasJunho);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @GetMapping("/julho")
    public String carregarListagemDespesasJulho(Model model) {
        List<Despesa> despesas = repository.findAll();
        List<Despesa> despesasJulho = new ArrayList<>();
        int mes;

        for (int i = 0; i < despesas.size(); i++) {
            mes = despesas.get(i).getDataVencimento().getMonthValue();

            if (mes == 7) {
                despesasJulho.add(despesas.get(i));
            }
        }

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesasJulho);
        BigDecimal totalPago = despesa.calculaTotalPago(despesasJulho);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesasJulho);

        model.addAttribute("listaDeDespesas", despesasJulho);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @GetMapping("/agosto")
    public String carregarListagemDespesasAgosto(Model model) {
        List<Despesa> despesas = repository.findAll();
        List<Despesa> despesasAgosto = new ArrayList<>();
        int mes;

        for (int i = 0; i < despesas.size(); i++) {
            mes = despesas.get(i).getDataVencimento().getMonthValue();

            if (mes == 8) {
                despesasAgosto.add(despesas.get(i));
            }
        }

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesasAgosto);
        BigDecimal totalPago = despesa.calculaTotalPago(despesasAgosto);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesasAgosto);

        model.addAttribute("listaDeDespesas", despesasAgosto);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @GetMapping("/setembro")
    public String carregarListagemDespesasSetembro(Model model) {
        List<Despesa> despesas = repository.findAll();
        List<Despesa> despesasSetembro = new ArrayList<>();
        int mes;

        for (int i = 0; i < despesas.size(); i++) {
            mes = despesas.get(i).getDataVencimento().getMonthValue();

            if (mes == 9) {
                despesasSetembro.add(despesas.get(i));
            }
        }

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesasSetembro);
        BigDecimal totalPago = despesa.calculaTotalPago(despesasSetembro);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesasSetembro);

        model.addAttribute("listaDeDespesas", despesasSetembro);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @GetMapping("/outubro")
    public String carregarListagemDespesasOutubro(Model model) {
        List<Despesa> despesas = repository.findAll();
        List<Despesa> despesasOutubro = new ArrayList<>();
        int mes;

        for (int i = 0; i < despesas.size(); i++) {
            mes = despesas.get(i).getDataVencimento().getMonthValue();

            if (mes == 10) {
                despesasOutubro.add(despesas.get(i));
            }
        }

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesasOutubro);
        BigDecimal totalPago = despesa.calculaTotalPago(despesasOutubro);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesasOutubro);

        model.addAttribute("listaDeDespesas", despesasOutubro);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @GetMapping("/novembro")
    public String carregarListagemDespesasNovembro(Model model) {
        List<Despesa> despesas = repository.findAll();
        List<Despesa> despesasNovembro = new ArrayList<>();
        int mes;

        for (int i = 0; i < despesas.size(); i++) {
            mes = despesas.get(i).getDataVencimento().getMonthValue();

            if (mes == 11) {
                despesasNovembro.add(despesas.get(i));
            }
        }

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesasNovembro);
        BigDecimal totalPago = despesa.calculaTotalPago(despesasNovembro);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesasNovembro);

        model.addAttribute("listaDeDespesas", despesasNovembro);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @GetMapping("/dezembro")
    public String carregarListagemDespesasDezembro(Model model) {
        List<Despesa> despesas = repository.findAll();
        List<Despesa> despesasDezembro = new ArrayList<>();
        int mes;

        for (int i = 0; i < despesas.size(); i++) {
            mes = despesas.get(i).getDataVencimento().getMonthValue();

            if (mes == 12) {
                despesasDezembro.add(despesas.get(i));
            }
        }

        var despesa = new Despesa();
        BigDecimal totalDespesas = despesa.calculaTotalDespesas(despesasDezembro);
        BigDecimal totalPago = despesa.calculaTotalPago(despesasDezembro);
        BigDecimal totalDevido = despesa.calculaTotalAPagar(despesasDezembro);

        model.addAttribute("listaDeDespesas", despesasDezembro);
        model.addAttribute("totalDespesas", totalDespesas);
        model.addAttribute("totalPago", totalPago);
        model.addAttribute("totalDevido", totalDevido);

        return "despesa/listagem";
    }

    @PostMapping
    @Transactional
    public String cadastrarDespesa(DadosCadastroDespesa dados) {
        var despesa = new Despesa(dados);
        repository.save(despesa);
        return "redirect:/despesas";
    }

    @PutMapping
    @Transactional
    public String atualizarDespesa(DadosAtualizaDespesa dados) {
        var despesa = repository.getReferenceById(dados.idDespesa());
        despesa.atualizaDados(dados);
        return "redirect:/despesas";
    }

    @DeleteMapping
    @Transactional
    public String deletarDespesa(Long idDespesa) {
        repository.deleteById(idDespesa);
        return "redirect:/despesas";
    }
}
