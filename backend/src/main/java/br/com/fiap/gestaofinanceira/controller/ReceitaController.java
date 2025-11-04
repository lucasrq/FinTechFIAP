package br.com.fiap.gestaofinanceira.controller;

import br.com.fiap.gestaofinanceira.model.Receita;
import br.com.fiap.gestaofinanceira.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Receita cadastrar(@RequestBody Receita receita){
        return receitaService.cadastrar(receita);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void excluir(@PathVariable Long id){
        receitaService.excluir(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receita buscarPorId(@PathVariable Long id){
        return receitaService.buscarPorid(id);
    }

    @GetMapping("/receita-usuario/{idUsuario}")
    @ResponseStatus(HttpStatus.OK)
    public List<Receita> buscarReceitaPorUsuario(@PathVariable("idUsuario") Long idUsuario){
        return receitaService.buscarTodas(idUsuario);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Receita atualizar(@PathVariable Long id, @RequestBody Receita receita){
        return receitaService.atualizar(id, receita);
    }
}