package br.com.fiap.gestaofinanceira.service;


import br.com.fiap.gestaofinanceira.model.Despesa;
import br.com.fiap.gestaofinanceira.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa cadastrarDespesa(Despesa despesa){
        return despesaRepository.save(despesa);
    }

    public void excluirDespesa(Long id){
        Optional<Despesa> despesa =despesaRepository.findById(id);

        if(despesa.isPresent()){
            despesaRepository.deleteById(id);
        }else{
            throw new RuntimeException("Despesa nao encontrada");
        }
    }

    public Despesa procurarDespesasPorId(Long id){
        Optional<Despesa> despesa = despesaRepository.findById(id);

        if(despesa.isPresent()){
            return despesa.get();
        }else {
            throw new RuntimeException("Despesa nao encontrada");
        }
    }

    public List<Despesa> buscarTodas(Long IdUsuario){
        return despesaRepository.findByUsuarioId(IdUsuario);
    }

    public Despesa atualizar(Long id, Despesa despesa){
        Optional<Despesa> despesaAtual = despesaRepository.findById(id);

        if(despesaAtual.isPresent()){
            return despesaRepository.save(despesa);
        }else {
            throw new RuntimeException("desepa nao encontrada");
        }
    }

}
