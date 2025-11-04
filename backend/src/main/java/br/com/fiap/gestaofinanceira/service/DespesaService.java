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

    public Despesa cadastrarDespesa(Despesa despesa) {
        return despesaRepository.save(despesa);
    }

    public void excluirDespesa(Long id) {
        Optional<Despesa> despesa = despesaRepository.findById(id);

        if (despesa.isPresent()) {
            despesaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Despesa nao encontrada");
        }
    }

    public Despesa procurarDespesasPorId(Long id) {
        Optional<Despesa> despesa = despesaRepository.findById(id);

        if (despesa.isPresent()) {
            return despesa.get();
        } else {
            throw new RuntimeException("Despesa nao encontrada");
        }
    }

    public List<Despesa> buscarTodas(Long IdUsuario) {
        return despesaRepository.findByUsuarioId(IdUsuario);
    }

    public Despesa atualizar(Long id, Despesa despesaAtualizada) {
        Optional<Despesa> optionalDespesaExistente = despesaRepository.findById(id);

        if (optionalDespesaExistente.isPresent()) {
            Despesa despesaExistente = optionalDespesaExistente.get();

            despesaExistente.setDescricao(despesaAtualizada.getDescricao());
            despesaExistente.setValor(despesaAtualizada.getValor());
            despesaExistente.setCategoria(despesaAtualizada.getCategoria());
            despesaExistente.setDataPagamento(despesaAtualizada.getDataPagamento());
            despesaExistente.setPago(despesaAtualizada.getPago());

            return despesaRepository.save(despesaExistente);
        } else {
            throw new RuntimeException("Despesa não localizada");
        }
    }
}