package br.com.fiap.gestaofinanceira.service;


import br.com.fiap.gestaofinanceira.model.Receita;
import br.com.fiap.gestaofinanceira.repository.ReceitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita cadastrar(Receita receita){
        return receitaRepository.save(receita);
    }


    public void excluir(Long id){
        Optional<Receita> receita = receitaRepository.findById(id);

        if(receita.isPresent()){
            receitaRepository.deleteById(id);
        }else{
            throw new RuntimeException("Receita não encontrada");
        }
    }


    public Receita buscarPorid(Long id){
        Optional<Receita> receita = receitaRepository.findById(id);
        if(receita.isPresent()){
            return receita.get();

        }else {
            throw new RuntimeException("Receita não encontrada");
        }
    }


    public List<Receita> buscarTodas(Long IdUsuario){
        return receitaRepository.findByUsuarioId(IdUsuario);
    }

    public Receita atualizar(Long id, Receita receita){
        Optional<Receita> receitaAtual = receitaRepository.findById(id);

        if(receitaAtual.isPresent()){
            return receitaRepository.save(receita);
        }else {
            throw new RuntimeException("Receita nao encontrada");
        }
    }

}
