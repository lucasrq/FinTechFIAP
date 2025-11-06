package br.com.fiap.gestaofinanceira.repository;

import br.com.fiap.gestaofinanceira.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    List<Receita> findByUsuarioId(Long idUsuario);
}