package br.com.fiap.gestaofinanceira.repository;

import br.com.fiap.gestaofinanceira.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario, Long>{
    Usuario findByEmail(String email);
}