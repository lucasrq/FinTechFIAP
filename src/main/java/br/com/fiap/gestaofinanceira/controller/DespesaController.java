package br.com.fiap.gestaofinanceira.controller;

import br.com.fiap.gestaofinanceira.model.Despesa;
import br.com.fiap.gestaofinanceira.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/despesa")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Despesa cadastrar(@RequestBody Despesa despesa){
        return despesaService.cadastrarDespesa(despesa);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void excluir(@PathVariable Long id){
        despesaService.excluirDespesa(id);
    }


    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Despesa buscarPorId(@PathVariable Long id){
        return despesaService.procurarDespesasPorId(id);
    }


    @GetMapping("/despesa-usuario/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public List<Despesa> buscarDespesaPorUsuario(@PathVariable("idUsuario") Long idUsuario){
        return despesaService.buscarTodas(idUsuario);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Despesa atualizar(@PathVariable Long id,@RequestBody Despesa despesa){
        return despesaService.atualizar(id, despesa);
    }
}
