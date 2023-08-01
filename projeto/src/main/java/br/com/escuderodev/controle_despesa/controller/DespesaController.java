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

import java.util.List;

@Controller
@RequestMapping("/despesas")
public class DespesaController {

    @Autowired
    private DespesaRepository repository;

    @GetMapping("formulario")
    public String carregarFormularioCadastro(Long id, Model model) {
//        if (id != null) {
//            var despesa = repository.getReferenceById(id);
//            model.addAttribute("despesa", despesa);
//        }
        return "despesa/formulario";
    }

    @GetMapping
    public String carregarListagemDespesas(Model model) {
//        List<Despesa> despesas = repository.findAll();
//        var despesa = new Despesa();
//        model.addAttribute("listaDeDespesas", despesas);
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
